package com.example.dynamicbudget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var total = intent.getFloatExtra("EXTRA_TOTAL", 0F)
        var grossPay = intent.getFloatExtra("EXTRA_GROSSPAY", 0F)
        var takeHomePay = intent.getFloatExtra("EXTRA_TAKEHOME", 0F)
        var leftOver = intent.getFloatExtra("EXTRA_LEFTOVER", 0F)
        var investment = intent.getFloatExtra("EXTRA_INVESTMENT", 0F)

        val equalCut = (leftOver/3F)

        tvReport.text = "Take Home Pay: $takeHomePay\nExpenses to be Paid: -$total\n\nInvestment Budget (15% of Gross): $investment\nFood Budget: $equalCut\nNecessities Budget $equalCut\nYourself Budget: $equalCut"




    }
}