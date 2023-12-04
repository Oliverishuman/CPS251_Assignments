package com.olmcmillen.contactsproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "productId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String? = null

    @ColumnInfo(name = "productQuantity")
    var productQuantity: Int = 0

    constructor() {}

    constructor(id: Int, productname: String, productquantity: Int) {
        this.productName = productname
        this.productQuantity = productquantity
    }
    constructor(productname: String, productquantity: Int) {
        this.productName = productname
        this.productQuantity = productquantity
    }


}