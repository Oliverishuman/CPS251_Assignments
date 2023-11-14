package com.olmcmillen.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.olmcmillen.explicitintent.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return
        val qString = extras.getString("qString")
        binding.textView2.text = qString

    }
}