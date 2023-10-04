package com.olmcmillen.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun calculateTip(view: View) {
        val dec = DecimalFormat("#,###.00")
        val billTotalText: EditText = findViewById(R.id.billTotalText)
        val resultView: TextView = findViewById(R.id.resultView)
        val noValueError: String = getString(R.string.noValueError)

        if (billTotalText.text.isNotEmpty()) {
            val dollarValue = billTotalText.text.toString().toFloat()
            val tenPercentTip = (dollarValue * 0.10f) + dollarValue
            val fifteenPercentTip = (dollarValue * 0.15f) + dollarValue
            val twentyPercentTip = (dollarValue * 0.20f) + dollarValue
            resultView.text = "The tips are as follows:\n\n10% = " + dec.format(tenPercentTip) + "\n15% = " + dec.format(fifteenPercentTip) + "\n20% = " + dec.format(twentyPercentTip)
        } else {
            resultView.text = noValueError
        }
    }
}