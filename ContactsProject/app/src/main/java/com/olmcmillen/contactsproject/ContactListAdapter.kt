package com.olmcmillen.contactsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olmcmillen.contactsproject.R.drawable.baseline_delete_24

class ContactListAdapter (private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>(){

    private var contactList: List<Contact>? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.itemName
        val quantity = holder.itemQuantity
//        val icon = holder.itemImage

        contactList.let {
            name.text = it!![listPosition].contactName
            quantity.text = it!![listPosition].contactPhone
//            icon.setImageResource(baseline_delete_24)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.contact_row_name)
        var itemQuantity: TextView = itemView.findViewById(R.id.contact_row_quantity)
//        var itemImage : ImageView = itemView.findViewById(R.id.contact_row_quantity)

    }

}