package com.olmcmillen.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application){

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        } }
    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }
    fun deleteContact(name: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }
    private fun asyncDelete(name: Int) {
        contactDao?.deleteContact(name)
    }
    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

}