package com.nyx.kls_financeaccounting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RepositoryImpl() : Repository {
    private val categories = MutableLiveData<List<FinanceCategory>>(listOf())
    private val categoriesLiveData: LiveData<List<FinanceCategory>> = categories

    override fun addCategory(category: FinanceCategory) {
        categories.value = mutableListOf<FinanceCategory>().apply {
            addAll(categories.value.orEmpty())
            add(category)
        }
    }

    override fun getCategories(): LiveData<List<FinanceCategory>> {
        return categoriesLiveData
    }
}