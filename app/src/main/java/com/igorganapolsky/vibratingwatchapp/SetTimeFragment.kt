package com.igorganapolsky.vibratingwatchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.fragment.app.Fragment

/**
 * Creates a Fragment that allows setting the time for a timer.
 */
class SetTimeFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_set_time, container, false)
        setupTimePicker()

        return rootView
    }

    private fun setupTimePicker() {
        val hoursPicker = rootView.findViewById<View>(R.id.hoursPicker) as NumberPicker
        hoursPicker.minValue = 0
        hoursPicker.maxValue = 12

        val minutesPicker = rootView.findViewById<View>(R.id.minutesPicker) as NumberPicker
        minutesPicker.minValue = 0
        minutesPicker.maxValue = 60

        val secondsPicker = rootView.findViewById<View>(R.id.secondsPicker) as NumberPicker
        secondsPicker.minValue = 0
        secondsPicker.maxValue = 60
    }
}
