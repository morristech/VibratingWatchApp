package com.igorganapolsky.vibratingwatchapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.wear.ambient.AmbientModeSupport
import com.google.android.material.tabs.TabLayout
import com.igorganapolsky.vibratingwatchapp.R
import com.igorganapolsky.vibratingwatchapp.adapters.CreateTimerFragmentAdaptor

/**
 * Creates a AddTimerActivity that allows adding new timer
 */
class AddTimerActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    private lateinit var mAmbientController: AmbientModeSupport.AmbientController
    private var mAdapter: CreateTimerFragmentAdaptor? = null
    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_timer)

        mAmbientController = AmbientModeSupport.attach(this)

        mAdapter = CreateTimerFragmentAdaptor(supportFragmentManager)
        mPager = findViewById(R.id.pager)
        mPager.adapter = mAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabDots)
        tabLayout.setupWithViewPager(mPager, true)
    }

    override fun getAmbientCallback(): AmbientModeSupport.AmbientCallback =
        MyAmbientCallback()


    private class MyAmbientCallback : AmbientModeSupport.AmbientCallback() {

        override fun onEnterAmbient(ambientDetails: Bundle?) {
        }

        override fun onExitAmbient() {
        }

        override fun onUpdateAmbient() {
        }
    }

    fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        mPager.setCurrentItem(item, smoothScroll)
    }
}
