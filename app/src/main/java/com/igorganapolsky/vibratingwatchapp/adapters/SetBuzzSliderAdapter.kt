package com.igorganapolsky.vibratingwatchapp.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.igorganapolsky.vibratingwatchapp.R

/**
 * Creates RecyclerView.Adapter for SetBuzzFragment recycle view
 */
class SetBuzzSliderAdapter : RecyclerView.Adapter<SetBuzzSliderItemViewHolder>() {

    private val data: ArrayList<String> = ArrayList()
    var callback: Callback? = null
    private val clickListener = View.OnClickListener { v -> v?.let { callback?.onItemClicked(it) } }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetBuzzSliderItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.set_buzz_slider_item, parent, false)

        itemView.setOnClickListener(clickListener)

        return SetBuzzSliderItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SetBuzzSliderItemViewHolder, position: Int) {
        holder.tvItem?.text = position.toString()
        holder.tvDescription?.text = data[position]

    }

    fun setData(data: ArrayList<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClicked(view: View)
    }
}

class SetBuzzSliderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvItem: TextView? = itemView?.findViewById(R.id.buzz_id)
    val tvDescription: TextView? = itemView?.findViewById(R.id.buzz_description)

}