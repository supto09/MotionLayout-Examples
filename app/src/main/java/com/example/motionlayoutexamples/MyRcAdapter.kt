package com.example.motionlayoutexamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class MyRcAdapter (private val context: Context) : ListAdapter<String, MyRcViewHolder>(MyDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRcViewHolder {
        val view = LayoutInflater.from(this.context).inflate(R.layout.item_recycler_view, parent, false)
        return MyRcViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRcViewHolder, position: Int) {
        holder.textView.text = getItem(position)
    }


}

class MyRcViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView = itemView.textView
}


class MyDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}