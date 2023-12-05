package com.olmcmillen.contactsproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    @ColumnInfo(name = "contactQuantity")
    var contactQuantity: Int = 0

    constructor() {}

    constructor(id: Int, contactname: String, contactquantity: Int) {
        this.contactName = contactname
        this.contactQuantity = contactquantity
    }
    constructor(contactname: String, contactquantity: Int) {
        this.contactName = contactname
        this.contactQuantity = contactquantity
    }


}