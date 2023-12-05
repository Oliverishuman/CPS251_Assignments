package com.olmcmillen.contactsproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName = :name")
    fun findContact(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactName = :name")
    fun deleteContact(name: String)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

}