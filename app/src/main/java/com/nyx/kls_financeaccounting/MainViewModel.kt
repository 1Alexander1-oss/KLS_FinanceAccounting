package com.nyx.kls_financeaccounting

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val repository: Repository
) : ViewModel() {
    fun createCategory(category: FinanceCategory) {
        repository.addCategory(category)
    }

    fun getCategories(): LiveData<List<FinanceCategory>> {
        return repository.getCategories()
    }
}