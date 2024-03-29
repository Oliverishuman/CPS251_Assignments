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

    fun insertContact(contact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(contact)
        } }
    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }
    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }
    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
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

    fun sortedAscContacts() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncSortAsc().await()
        }
    }

    private fun asyncSortAsc(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.sortedAscContacts()
        }

    fun sortedDescContacts() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncSortDesc().await()
        }
    }

    private fun asyncSortDesc(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.sortedDescContacts()
        }

}