package com.olmcmillen.lifecycleawareness
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object{
        private var textToWatch: MutableLiveData<String> = MutableLiveData()

        fun setText (value: String) {
                textToWatch.value += value + "\n"
        }
    }

    fun getText(): MutableLiveData<String>{
        return textToWatch
    }

}