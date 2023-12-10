package com.olmcmillen.contactsproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter (private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>(){

    private var contactList: List<Contact>? = null
    private var listener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.itemName
        val phone = holder.itemPhone
        val id = holder.id
        var deleteIcon = holder.itemDeleteIcon

        contactList.let {
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].contactPhone
            id.text = it!![listPosition].id.toString()
        }

        deleteIcon.setOnClickListener(View.OnClickListener{
            Log.d("ContactListAdapter", "deleteButton clicked " + id.text.toString())
            listener?.onClick(id.text.toString())
        })
    }

    interface OnItemClickListener {
        fun onClick(string: String){
            Log.d("ContactListAdapter", "onItemClickListener")
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

    fun setListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.nameView)
        var itemPhone: TextView = itemView.findViewById(R.id.phoneView)
        var id: TextView = itemView.findViewById(R.id.id)
        var itemDeleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
    }
}