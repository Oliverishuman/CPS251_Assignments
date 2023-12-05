package com.olmcmillen.contactsproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.jar.Attributes.Name

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val sortedAscContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
        sortedAscContacts = repository.sortedAscContacts
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(name: Int) {
        repository.deleteContact(name)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

    fun sortByAsc(): LiveData<List<Contact>>?{
        return sortedAscContacts
    }

}