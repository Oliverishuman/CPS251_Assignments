package com.olmcmillen.contactsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.olmcmillen.contactsproject.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }

    private fun listenerSetup() {
        binding.contactName.requestFocus()

        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactPhone.text.toString()

            if (name != "" && quantity != "") {
                val contact = Contact(name, quantity)
                viewModel.insertContact(contact)
                clearFields()

            } else {
                val toast = Toast.makeText(this, "Please enter name and phone number", Toast.LENGTH_LONG)

                toast.show()
            }
            binding.contactName.requestFocus()
        }

        binding.findButton.setOnClickListener {
            if (binding.contactName.text.isNotEmpty()) {
                viewModel.findContact(binding.contactName.text.toString())
                clearFields()
            } else {
                val toast = Toast.makeText(this, "You must enter name to search", Toast.LENGTH_LONG)
                toast.show()
            }
            binding.contactName.requestFocus()
        }

        binding.ascButton.setOnClickListener{
            viewModel.sortByAsc()
            binding.contactName.requestFocus()

        }

        binding.descButton.setOnClickListener{
            viewModel.sortByDesc()
            binding.contactName.requestFocus()

        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let {

                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    val toast = Toast.makeText(this, "There are no contacts that match your search", Toast.LENGTH_LONG)
                    toast.show()
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this)
        binding.contactRecycler.adapter = adapter

        adapter!!.setListener(object: ContactListAdapter.OnItemClickListener{
            override fun onClick(string: String) {
                viewModel.deleteContact(Integer.parseInt(string))
//                Log.d("MainFragment", "Contact Detected, ID: " + string)
                val toast = Toast.makeText(applicationContext,
                    "Contact Detected, ID: $string", Toast.LENGTH_LONG)
                toast.show()
            }
        })
    }

}