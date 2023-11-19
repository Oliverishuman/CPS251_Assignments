package com.olmcmillen.recycleviewintentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olmcmillen.recycleviewintentsproject.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val dataClass = Data()

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val titleText = extras.getInt("title")
        val detailsText = extras.getInt("detail")
        val imageView = extras.getInt("image")

        binding.titleTextView.text = dataClass.titles[titleText]
        binding.detailsTextView.text = dataClass.details[detailsText]
        binding.imageView.setImageResource(dataClass.images[imageView])
    }
}