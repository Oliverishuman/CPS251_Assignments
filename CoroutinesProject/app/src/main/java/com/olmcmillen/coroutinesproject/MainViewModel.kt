package com.olmcmillen.coroutinesproject

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var namesArray = ArrayList<String>()

    fun addNames(name: String) {
        namesArray += name
    }

    fun getNames(): ArrayList<String> {
        return namesArray
    }

}