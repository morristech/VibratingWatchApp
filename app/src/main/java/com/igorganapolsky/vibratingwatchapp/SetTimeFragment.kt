package com.igorganapolsky.vibratingwatchapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker

/**
 * Returns an SetTimeFragment object
 */
class SetTimeFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_set_time, container, false)
        setupTimePicker()

        return rootView
    }

    private fun setupTimePicker(){
        val minutesPicker = rootView.findViewById<View>(R.id.minutesPicker) as NumberPicker
        minutesPicker.minValue = 0
        minutesPicker.maxValue = 99

        val secondsPicker = rootView.findViewById<View>(R.id.secondsPicker) as NumberPicker
        secondsPicker.minValue = 0
        secondsPicker.maxValue = 60
    }
}
