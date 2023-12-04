package com.olmcmillen.roomdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductListAdapter (private val productItemLayout: Int) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>(){

    private var productList: List<Product>? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.itemName
        val quantity = holder.itemQuantity

        productList.let {
            name.text = it!![listPosition].productName
            quantity.text = it!![listPosition].productQuantity.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            productItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setProductList(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (productList == null) 0 else productList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.product_row_name)
        var itemQuantity: TextView = itemView.findViewById(R.id.product_row_quantity)

    }

}