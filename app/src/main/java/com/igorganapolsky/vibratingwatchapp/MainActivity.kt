package com.igorganapolsky.vibratingwatchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.wear.ambient.AmbientModeSupport
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.FragmentPagerAdapter

class MainActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    private lateinit var mAmbientController: AmbientModeSupport.AmbientController
    var mAdapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAmbientController = AmbientModeSupport.attach(this)

        mAdapter =  MyAdapter(supportFragmentManager)
        val mPager = findViewById<ViewPager>(R.id.pager)
        mPager.adapter = mAdapter;

        val tabLayout = findViewById<TabLayout>(R.id.tabDots)
        tabLayout.setupWithViewPager(mPager, true)
    }

    override fun getAmbientCallback(): AmbientModeSupport.AmbientCallback = MyAmbientCallback()


    private class MyAmbientCallback : AmbientModeSupport.AmbientCallback() {

        override fun onEnterAmbient(ambientDetails: Bundle?) {
        }

        override fun onExitAmbient() {
        }

        override fun onUpdateAmbient() {
        }
    }

    class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount(): Int {
            return 4
        }

        override fun getItem(position: Int): Fragment {

            return AddTimerFragment()
        }
    }
}
