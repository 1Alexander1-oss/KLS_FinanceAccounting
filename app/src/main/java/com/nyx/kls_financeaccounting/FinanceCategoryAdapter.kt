package com.nyx.kls_financeaccounting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FinanceCategoryViewHolder(
    itemView: View,
    private val listener: FinanceCategoryClickListener,
) : RecyclerView.ViewHolder(itemView) {
    fun setContent(financeCategory: FinanceCategory) {

        val categoryTextView = itemView.findViewById<TextView>(R.id.title)
        categoryTextView.text = financeCategory.name
        val categoryTextView2 = itemView.findViewById<TextView>(R.id.percent)
        categoryTextView2.text = financeCategory.ratio.toString()

        itemView.setOnClickListener {
            financeCategory.id?.let { id ->
                listener.categoryClick(id)
            }
        }
    }
}


class FinanceCategoryAdapter(
    private val financialCategories: List<FinanceCategory>,
    private val listener: FinanceCategoryClickListener,
) : RecyclerView.Adapter<FinanceCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceCategoryViewHolder {
        return FinanceCategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.accounting_item,
                parent,
                false
            ),
            listener
        )
    }

    override fun onBindViewHolder(holder: FinanceCategoryViewHolder, position: Int) {
        val financeCategory = financialCategories[position]
        holder.setContent(financeCategory)
    }

    override fun getItemCount(): Int {
        return financialCategories.size
    }
}