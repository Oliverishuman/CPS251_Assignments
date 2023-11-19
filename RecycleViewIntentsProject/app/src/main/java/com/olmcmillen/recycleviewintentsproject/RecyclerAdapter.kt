package com.olmcmillen.recycleviewintentsproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private val dataClass = Data()
    private var imageNumber=0
    private var titleNumber=0
    private var detailNumber=0

    class ViewHolder (itemView: View, detailNumber: Int, titleNumber : Int, imageNumber: Int) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView


        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View  ->
                val i = Intent(v.context, MainActivity2::class.java)


                i.putExtra("title", titleNumber)
                i.putExtra("detail", imageNumber)
                i.putExtra("image", detailNumber)


                startActivity(v.context,i,null)
            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)

        val imageNumber = Random.nextInt(0, 7)
        val titleNumber = Random.nextInt(0, 7)
        val detailNumber = Random.nextInt(0, 7)

        this.imageNumber = imageNumber
        this.titleNumber = titleNumber
        this.detailNumber = detailNumber

        return ViewHolder(v, imageNumber, titleNumber, detailNumber)
    }

    override fun getItemCount(): Int {
        return dataClass.titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = dataClass.titles[titleNumber]
        viewHolder.itemDetail.text = dataClass.details[detailNumber]
        viewHolder.itemImage.setImageResource(dataClass.images[imageNumber])

    }

}
