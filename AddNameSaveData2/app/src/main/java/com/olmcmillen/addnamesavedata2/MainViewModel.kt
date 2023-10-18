package com.olmcmillen.addnamesavedata2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var savedNames = ""
    var enterName: MutableLiveData<String> = MutableLiveData()
    var namesView: MutableLiveData<String> = MutableLiveData()

    fun addNames() {

        if (!enterName.value.equals("")) {
            savedNames += enterName.value.toString() + "\n"
            namesView.value = savedNames

        } else {
            namesView.value = "No Names Entered"
        }

    }


//
//    fun setNames (value: String) {
//        this.enterName = value
//
//        namesView += (enterName + "\n")
//    }
//
//    fun getNames(): String{
//        return namesView
//    }

}