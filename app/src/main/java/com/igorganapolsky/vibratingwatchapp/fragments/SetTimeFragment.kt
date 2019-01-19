package com.igorganapolsky.vibratingwatchapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import com.igorganapolsky.vibratingwatchapp.R
import androidx.lifecycle.ViewModelProviders
import com.igorganapolsky.vibratingwatchapp.classes.TimerViewModel

/**
 * Creates a Fragment that allows setting the time for a timer
 */
class SetTimeFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var timerModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        timerModel = ViewModelProviders.of(activity!!).get(TimerViewModel::class.java!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_set_time, container, false)

        setupTimePicker()

        return rootView
    }

    private fun setupTimePicker(){
        val hoursPicker = rootView.findViewById<View>(R.id.hoursPicker) as NumberPicker
        hoursPicker.minValue = 0
        hoursPicker.maxValue = 12
        hoursPicker.setFormatter { i -> String.format("%02d", i) }
        hoursPicker.value = timerModel.getTimer()!!.getHours()
        hoursPicker.setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
            override fun onValueChange(numberPicker: NumberPicker, i: Int, i2: Int) {
                timerModel.getTimer()?.setHours(i2)
            }
        })

        val minutesPicker = rootView.findViewById<View>(R.id.minutesPicker) as NumberPicker
        minutesPicker.minValue = 0
        minutesPicker.maxValue = 60
        minutesPicker.setFormatter { i -> String.format("%02d", i) }
        minutesPicker.value = timerModel.getTimer()!!.getMinutes()
        minutesPicker.setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
            override fun onValueChange(numberPicker: NumberPicker, i: Int, i2: Int) {
                timerModel.getTimer()?.setMinutes(i2)
            }
        })

        val secondsPicker = rootView.findViewById<View>(R.id.secondsPicker) as NumberPicker
        secondsPicker.minValue = 0
        secondsPicker.maxValue = 60
        secondsPicker.setFormatter { i -> String.format("%02d", i) }
        secondsPicker.value = timerModel.getTimer()!!.getSeconds()
        secondsPicker.setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
            override fun onValueChange(numberPicker: NumberPicker, i: Int, i2: Int) {
                timerModel.getTimer()?.setSeconds(i2)
            }
        })
    }
}
