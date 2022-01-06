package com.hmomeni.verticalslider.sorrtradar

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hmomeni.verticalslider.VerticalSlider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.control_view.*
import java.util.*


import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Calling mainActivity& customActivity
        setContentView(R.layout.control_view)
        setContentView(R.layout.activity_main)

        //Setting the values so that slider changes based on them
        verticalSlider.max = 100
        verticalSlider.progress = 10
        verticalSlider.cornerRadius = resources.displayMetrics.density * 30

        //Setting vector assists on slider so it moves based on volume level
        verticalSlider.setIconHighResource(R.drawable.ic_volume_high_grey600_36dp)
        verticalSlider.setIconMediumResource(R.drawable.ic_volume_medium_grey600_36dp)
        verticalSlider.setIconLowResource(R.drawable.ic_volume_low_grey600_36dp)

        //Changing the value of tV based on the movement of the slider
        verticalSlider.onProgressChangeListener = object : VerticalSlider.OnSliderProgressChangeListener {
            override fun onChanged(progress: Int, max: Int) {
                progressText.text = "%.0f%%".format(Locale.ENGLISH, progress.toFloat() / max.toFloat() * 100)
            }
        }
        //onChangeListener so it notice the entered value
        etCount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }


            //Change the value based on the new one
            override fun onTextChanged(s: CharSequence, after: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {

                button.setOnClickListener(){

                    try {
                        //Update Seekbar value after entering a number


                        val progress = Math.round(s.toString().toFloat())
                        verticalSlider.progress = (progress)

                        etCount.setText(etCount.text.length)
                    } catch (ex: Exception) {
                    }
                }


            }

        })
    }



}
