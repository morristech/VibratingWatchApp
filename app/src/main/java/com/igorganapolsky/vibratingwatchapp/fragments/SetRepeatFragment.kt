package com.igorganapolsky.vibratingwatchapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.nbtk.slider.ScreenUtils
import com.igorganapolsky.vibratingwatchapp.R
import com.igorganapolsky.vibratingwatchapp.adapters.SetRepeatSliderAdapter
import com.igorganapolsky.vibratingwatchapp.SetRepeatSliderLayoutManager
import com.igorganapolsky.vibratingwatchapp.activities.TimersListActivity
import com.igorganapolsky.vibratingwatchapp.classes.TimerViewModel

/**
 * Creates a Fragment that allows setting time for a timer
 */
class SetRepeatFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var rvRepeatPicker: RecyclerView
    private val data = (1..99).toList().map { it.toString() } as ArrayList<String>
    private lateinit var timerModel: TimerViewModel
    private lateinit var tvTime: TextView
    private var isFragmentStarted = false
    private var isFragmentVisible = false
    lateinit var hours : String
    lateinit var minutes : String
    lateinit var seconds : String


    override fun onStart() {
        super.onStart()
        isFragmentStarted = true
        if (isFragmentVisible && isFragmentStarted){
            setTimer()
        }
    }

    fun setTimer(){
        timerModel = ViewModelProviders.of(activity!!).get(TimerViewModel::class.java!!)
         hours = String.format("%02d", timerModel.getTimer()!!.getHours())
        minutes = String.format("%02d", timerModel.getTimer()!!.getMinutes())
        seconds = String.format("%02d", timerModel.getTimer()!!.getSeconds())
        tvTime.text = "$hours : $minutes : $seconds"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_set_repeat, container, false)
        tvTime = rootView.findViewById(R.id.tvTime)

        setConfirmButton()
        setHorizontalPicker()
        return rootView
    }

    override fun setUserVisibleHint( isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        isFragmentVisible = isVisibleToUser
        if (isFragmentStarted && isFragmentVisible) {
            setTimer()
        } else {
            isFragmentVisible = false
        }
    }

    private fun setHorizontalPicker() {
        rvRepeatPicker = rootView.findViewById(R.id.repeat_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(this.requireActivity())/2 - ScreenUtils.dpToPx(this.requireActivity(), 40)
        rvRepeatPicker.setPadding(padding, 0, padding, 0)

        // Setting layout manager
        rvRepeatPicker.layoutManager = SetRepeatSliderLayoutManager(this.requireActivity()).apply {
            callback = object : SetRepeatSliderLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(position: Int) {
                }
            }
        }

        // Setting Adapter
        rvRepeatPicker.adapter = SetRepeatSliderAdapter().apply {
            setData(data)
            callback = object : SetRepeatSliderAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvRepeatPicker.smoothScrollToPosition(rvRepeatPicker.getChildLayoutPosition(view))
                }
            }
        }
    }

    private fun setConfirmButton() {
        val button = rootView.findViewById<ImageButton>(R.id.confirmBtn)
        button.setOnClickListener {
            val intent = Intent(activity, TimersListActivity::class.java)
            startActivity(intent)
        }

    }
}
