package com.nyx.kls_financeaccounting

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nyx.kls_financeaccounting.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {
    fun createCategory(category: FinanceCategory) {
        repository.addCategory(category)
    }

    fun getCategories(): LiveData<List<FinanceCategory>> {
        return repository.getCategories()
    }

    fun deleteCategory(category: FinanceCategory) {
        repository.deleteCategory(category)
    }
}