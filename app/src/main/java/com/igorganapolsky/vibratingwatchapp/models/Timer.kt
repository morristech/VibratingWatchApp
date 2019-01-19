package com.igorganapolsky.vibratingwatchapp.models

class Timer {

    private var hours: Int = 0
    private var minutes: Int = 0
    private var seconds: Int = 0
    private var buzzId: Int = 0
    private var repeatCount: Int = 0

    fun setHours(hours: Int) {
        this.hours = hours
    }

    fun getHours(): Int {
        return this.hours
    }

    fun setMinutes(minutes: Int) {
        this.minutes = minutes
    }

    fun getMinutes(): Int {
        return this.minutes
    }

    fun setSeconds(seconds: Int) {
        this.seconds = seconds
    }

    fun getSeconds(): Int {
        return this.seconds
    }

    fun setBuzzId(buzzId: Int) {
        this.buzzId = buzzId
    }

    fun getBuzzId(): Int {
        return this.buzzId
    }

    fun getRepeatCount(): Int {
        return this.repeatCount
    }

    fun setRepeatCount(repeatCount: Int) {
        this.repeatCount = repeatCount
    }

}