package com.olmcmillen.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olmcmillen.explicitintent.databinding.ActivityMainBinding
import android.view.View
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun sendText(view: View) {
        val i = Intent(this, SecondActivity::class.java)
        val myString = binding.editText1.text.toString()
        i.putExtra("qString", myString)
        startActivity(i)
    }

}