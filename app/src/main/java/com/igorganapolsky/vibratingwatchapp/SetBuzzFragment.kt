package com.igorganapolsky.vibratingwatchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Creates a Fragment that allows setting buzz for a timer.
 */
class SetBuzzFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_buzz, container, false)
    }


}
