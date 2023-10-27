package com.olmcmillen.lifecycleawareness
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object{
        private var textToWatch: MutableLiveData<String> = MutableLiveData()
        private var emptyString = ""

        fun setText (value: String) {
            emptyString += value + "\n"
            textToWatch.setValue(emptyString)
        }
    }

    fun getText(): MutableLiveData<String>{
        return textToWatch
    }

}