package com.nyx.kls_financeaccounting

import androidx.lifecycle.LiveData

interface Repository {
    fun getCategories(): LiveData<List<FinanceCategory>>
    fun addCategory(category: FinanceCategory)
}