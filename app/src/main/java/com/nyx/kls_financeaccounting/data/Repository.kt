package com.nyx.kls_financeaccounting.data

import androidx.lifecycle.LiveData
import com.nyx.kls_financeaccounting.FinanceCategory

interface Repository {
    fun getCategories(): LiveData<List<FinanceCategory>>
    fun addCategory(category: FinanceCategory)
}