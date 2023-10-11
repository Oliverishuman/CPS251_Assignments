package com.olmcmillen.addnamesavedata1
import androidx.lifecycle.ViewModel
class MainViewModel : ViewModel() {

    private var enterName = ""
    private var namesView = ""

    fun setNames (value: String) {
        this.enterName = value

        namesView += ("\n" + enterName)
    }

    fun getNames(): String{
        return namesView
    }

}