package com.igorganapolsky.vibratingwatchapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Creates an CreateTimerFragmentAdaptor object that controls changing fragments for creating new time
 */
class CreateTimerFragmentAdaptor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SetTimeFragment()
            1 -> SetBuzzFragment()
            2 -> SetBuzzFragment()
            else -> {
                SetTimeFragment()
            }
        }
    }
}