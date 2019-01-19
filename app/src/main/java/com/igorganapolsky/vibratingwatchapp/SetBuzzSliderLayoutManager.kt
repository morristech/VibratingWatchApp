package com.igorganapolsky.vibratingwatchapp

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

class SetBuzzSliderLayoutManager(context: Context?) : LinearLayoutManager(context) {

    init {
        orientation = RecyclerView.VERTICAL
    }

    var callback: OnItemSelectedListener? = null
    private lateinit var recyclerView: RecyclerView

    override fun onAttachedToWindow(view: RecyclerView?) {
        super.onAttachedToWindow(view)
        recyclerView = view!!

        // Smart snapping
        LinearSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun scrollVerticallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        return if (orientation == LinearLayoutManager.VERTICAL) {
            val scrolled = super.scrollVerticallyBy(dx, recycler, state)
            scrolled
        } else {
            0
        }
    }

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)

        // When scroll stops we notify on the selected item
        if (state == RecyclerView.SCROLL_STATE_IDLE) {

            // Find the closest child to the recyclerView center --> this is the selected item.

            val recyclerViewCenterX = getRecyclerViewCenterY()

            var minDistance = recyclerView.height

            var position = -1
            for (i in 0 until recyclerView.childCount) {
                val child = recyclerView.getChildAt(i)
                val childCenterX = getDecoratedTop(child) + (getDecoratedBottom(child) - getDecoratedTop(child)) / 2
                var newDistance = Math.abs(childCenterX - recyclerViewCenterX)
                if (newDistance < minDistance) {
                    minDistance = newDistance
                    position = recyclerView.getChildLayoutPosition(child)
                }
            }

            // Notify on item selection
            callback?.onItemSelected(position)
        }
    }

    private fun getRecyclerViewCenterX() : Int {
        return (recyclerView.right - recyclerView.left)/2 + recyclerView.left
    }

    private fun getRecyclerViewCenterY() : Int {
        return (recyclerView.top - recyclerView.bottom)/2 + recyclerView.bottom
    }


    interface OnItemSelectedListener {
        fun onItemSelected(position: Int)
    }
}