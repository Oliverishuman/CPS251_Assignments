package com.olmcmillen.contactsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding.contactID.text = ""
        binding.contactName.setText("")
        binding.contactQuantity.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactQuantity.text.toString()

            if (name != "" && quantity != "") {
                val contact = Contact(name, Integer.parseInt(quantity))
                viewModel.insertContact(contact)
                clearFields()
            } else {
                binding.contactID.text = "Incomplete information"
            }
        }

        binding.findButton.setOnClickListener { viewModel.findContact(
            binding.contactName.text.toString()) }

        binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.contactName.text.toString())

            clearFields()
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
                    binding.contactID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.contactName.setText(it[0].contactName)
                    binding.contactQuantity.setText(
                        String.format(
                            Locale.US, "%d",
                            it[0].contactQuantity
                        )
                    )
                } else {
                    binding.contactID.text = "No Match"
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this)
        binding.contactRecycler.adapter = adapter
    }

}