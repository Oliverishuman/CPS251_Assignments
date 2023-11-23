package com.olmcmillen.coroutinesproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val namesArray = ArrayList<String>()

    val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    fun addNames(name: String) {
        namesArray.add(name)
    }

    fun getNames(): ArrayList<String> {
        return namesArray
    }

}