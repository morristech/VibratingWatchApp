package com.igorganapolsky.vibratingwatchapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CreateTimerFragmentAdaptor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AddTimerFragment()
            1 -> SetTimeFragment()
            2 -> SetBuzzFragment()
            else -> {
                AddTimerFragment()
            }
        }
    }
}