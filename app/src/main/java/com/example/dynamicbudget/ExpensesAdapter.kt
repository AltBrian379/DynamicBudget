package com.example.dynamicbudget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.expense_element.view.*

class ExpensesAdapter (
    private val expenses: MutableList<Expense>
    ) : RecyclerView.Adapter<ExpensesAdapter.ExpensesViewHolder>() {

    class ExpensesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        return ExpensesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.expense_element,
                parent,
                false
            )
        )
    }

    fun addExpense(expense: Expense){
        expenses.add(expense)
        notifyItemInserted(expenses.size - 1)


    }

    fun getExpenses() : MutableList<Expense> {
        return expenses
    }



    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        val curExpense = expenses[position]
        holder.itemView.apply{
            tvExpenseTitle.text = curExpense.name
            tvExpensePrice.text = curExpense.value.toString()
        }
    }

    override fun getItemCount(): Int {
        return expenses.size
    }


}