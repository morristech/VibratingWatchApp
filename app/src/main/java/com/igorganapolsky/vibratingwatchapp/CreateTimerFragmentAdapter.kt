package com.igorganapolsky.vibratingwatchapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Creates an [FragmentPagerAdapter] that controls changing fragments when creating a new timer.
 */
class CreateTimerFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

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