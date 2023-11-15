package com.olmcmillen.recycleviewintentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import com.olmcmillen.recycleviewintentsproject.databinding.ActivityMain2Binding
import com.olmcmillen.recycleviewintentsproject.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val titleText = extras.getString("title")
        val detailsText = extras.getString("detail")
        val imageView = extras.getInt("image")

        binding.titleTextView.text = titleText
        binding.detailsTextView.text = detailsText
        binding.imageView.setImageDrawable(imageView.toDrawable())

    }
}