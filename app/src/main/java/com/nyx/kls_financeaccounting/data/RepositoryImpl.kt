package com.nyx.kls_financeaccounting.data

import androidx.lifecycle.LiveData
import com.nyx.kls_financeaccounting.FinanceCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositoryImpl(
    val dao: FinanceCategoryDao,
) : Repository {
    override fun addCategory(category: FinanceCategory) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertCategory(category)
        }
    }

    override fun getCategories(): LiveData<List<FinanceCategory>> {
        return dao.getCategories()
    }

    override fun deleteCategory(category: FinanceCategory) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteCategory(category)
        }
    }
}