package com.olmcmillen.lifecycleawareness
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var enterName = ""
    private var namesView = ""

    fun setNames (value: String) {
        this.enterName = value

        namesView += (enterName + "\n")
    }

    fun getNames(): String{
        return namesView
    }

}