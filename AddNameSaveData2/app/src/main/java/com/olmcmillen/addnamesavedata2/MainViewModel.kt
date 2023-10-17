package com.olmcmillen.addnamesavedata2
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

//    private var enterName = ""
//    private var namesView = ""

    var enterName: MutableLiveData<String> = MutableLiveData()
    var namesView: MutableLiveData<String> = MutableLiveData()

    fun addNames() {
        val enteredNames = mutableListOf<String>()

        enterName.let {
            val enteredNames = mutableListOf<String>()

            if (!it.value.equals("")) {
                // Append the entered name to the list
                enteredNames.add(enterName.value.toString())
            }

            // Update the namesView to display the list of names or the error message
            if (enteredNames.isNotEmpty()) {
                namesView.value = enteredNames.joinToString("\n")
            } else {
                // If no name is entered, show an error message
                namesView.value = "No Name Entered"
            }
//
//            if (!it.value.equals("")) {
//                enteredNames.add(enterName.value.toString() + "\n")
//
//                namesView.value += enteredNames.toString()
//
//            } else {
//                namesView.value = "No Names Entered"
//            }
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