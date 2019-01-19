package com.igorganapolsky.vibratingwatchapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.wear.ambient.AmbientModeSupport
import com.igorganapolsky.vibratingwatchapp.R

class MainActivity : AppCompatActivity(), AmbientModeSupport.AmbientCallbackProvider {

    private lateinit var mAmbientController: AmbientModeSupport.AmbientController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAmbientController = AmbientModeSupport.attach(this)
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

    fun addTimer(view: View){
        val intent = Intent(this, AddTimerActivity::class.java)
        startActivity(intent)
    }

}
