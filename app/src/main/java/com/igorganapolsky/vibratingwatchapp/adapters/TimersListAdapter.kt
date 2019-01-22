package com.igorganapolsky.vibratingwatchapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igorganapolsky.vibratingwatchapp.R
import org.w3c.dom.Text

class TimersListAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<TimersListAdapter.TimersListViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimersListAdapter.TimersListViewHolder {
        // create a new view
        val parentView = LayoutInflater.from(parent.context).inflate(R.layout.timers_list_item, parent, false) as LinearLayout
        // set the view's size, margins, paddings and layout parameters

        return TimersListViewHolder(parentView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: TimersListViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.vTime.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = 5

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class TimersListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vTime = view.findViewById(R.id.time) as TextView

//
//        init {
////            vTime = (TextView) view.findViewById(R.id.selectSwitch);
//        }
    }

}