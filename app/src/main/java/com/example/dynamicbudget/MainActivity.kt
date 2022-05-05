package com.example.dynamicbudget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var expensesAdapter : ExpensesAdapter
    private lateinit var rpt : Report



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expensesAdapter = ExpensesAdapter(mutableListOf())

        rvExpenses.adapter = expensesAdapter
        rvExpenses.layoutManager = LinearLayoutManager(this)

        btnAddExpense.setOnClickListener {
            val expenseTitle = etExpenseTitle.text.toString()
            val expenseAmount = etExpenseAmount.text.toString().toFloat()

            if(expenseTitle.isNotEmpty() || expenseAmount != 0.00F){
                val expense = Expense(expenseTitle,expenseAmount)
                expensesAdapter.addExpense(expense)
                etExpenseTitle.text.clear()
                etExpenseAmount.text.clear()

            }

        }

        btnProcess.setOnClickListener {
           val explist = expensesAdapter.getExpenses()
           val grossPay = etGrossPay.text.toString().toFloat()
           val takeHomePay = etTakeHomePay.text.toString().toFloat()
           var investmentCut = (grossPay * .15F)

           var total: Float = 0.0F
           for(i in explist)
           {
               total += i.value
           }

           val leftover = (takeHomePay - total) - investmentCut

          // rpt = Report(explist.size,
          //     total,
          //     grossPay,
          //     takeHomePay,
          //     leftover,
          //     investmentCut
          // )

           Intent(this,MainActivity2::class.java).also{
              it.putExtra("EXTRA_TOTAL",total)
              it.putExtra("EXTRA_GROSSPAY",grossPay)
              it.putExtra("EXTRA_TAKEHOME",takeHomePay)
              it.putExtra("EXTRA_LEFTOVER",leftover)
              it.putExtra("EXTRA_INVESTMENT",investmentCut)
               startActivity(it)
           }






        }
    }

    fun getReportObj () : Report{
        return rpt
    }
}