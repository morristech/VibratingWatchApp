package com.igorganapolsky.vibratingwatchapp.classes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.igorganapolsky.vibratingwatchapp.models.Timer

class TimerViewModel : ViewModel() {

    private val timer = MutableLiveData<Timer>()

    init {
        timer.value = Timer()
    }

    fun getTimer() : Timer? {
        return timer.value
    }
}