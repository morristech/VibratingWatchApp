package com.igorganapolsky.vibratingwatchapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.igorganapolsky.vibratingwatchapp.classes.ScreenUtils
import com.igorganapolsky.vibratingwatchapp.R
import com.igorganapolsky.vibratingwatchapp.SetBuzzSliderLayoutManager
import com.igorganapolsky.vibratingwatchapp.adapters.SetBuzzSliderAdapter
import com.igorganapolsky.vibratingwatchapp.classes.TimerViewModel


/**
 * A [Fragment] that allows the user to set buzz
 */
class SetBuzzFragment : Fragment() {
    private lateinit var rootView: View
    private lateinit var rvBuzzPicker: RecyclerView
    private val BUZZLIST = arrayListOf("1 buzz - 5 seconds", "3 buzz - 3 seconds each", "5 buzzes - 5 seconds each", "1 long buzz - 20 seconds")
    private lateinit var _context : Context
    private lateinit var timerModel: TimerViewModel
    private lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        timerModel = ViewModelProviders.of(activity!!).get(TimerViewModel::class.java!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _context = this.requireContext()
        rootView = inflater.inflate(R.layout.fragment_set_buzz, container, false)
        tvTime = rootView.findViewById(R.id.tvTime)
        setBuzzPicker()
        return rootView
    }

    override fun setUserVisibleHint( isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            val hours = String.format("%02d", timerModel.getTimer()!!.getHours())
            val minutes = String.format("%02d", timerModel.getTimer()!!.getMinutes())
            val seconds = String.format("%02d", timerModel.getTimer()!!.getSeconds())
            val time =  "$hours : $minutes : $seconds"
            tvTime.text = time
        }
    }

    private fun setBuzzPicker() {
        rvBuzzPicker = rootView.findViewById(R.id.buzz_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(this.requireActivity())/2 - ScreenUtils.dpToPx(this.requireActivity(), 30)
        rvBuzzPicker.setPadding(0, padding - 40, 0, padding)

        // Setting layout manager
        rvBuzzPicker.layoutManager = SetBuzzSliderLayoutManager(this.requireActivity()).apply {
            callback = object : SetBuzzSliderLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(position: Int) {
                }
            }
        }

        // Setting Adapter
        rvBuzzPicker.adapter = SetBuzzSliderAdapter().apply {
            setData(BUZZLIST)
            callback = object : SetBuzzSliderAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvBuzzPicker.smoothScrollToPosition(rvBuzzPicker.getChildLayoutPosition(view))
                }
            }
        }
    }


}
