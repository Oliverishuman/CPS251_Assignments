package com.olmcmillen.coroutinesproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private var namesArray = viewModel.getNames()

//    private val dataClass = Data()

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemDetail: TextView

        init {
            itemDetail = itemView.findViewById(R.id.itemDetail)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return namesArray.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemDetail.text = namesArray[i]
    }

}