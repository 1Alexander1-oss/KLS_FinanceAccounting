package com.nyx.kls_financeaccounting

interface FinanceCategoryClickListener {
    fun categoryClick(id: Int)
    fun onDeletePressed(category: FinanceCategory)
}