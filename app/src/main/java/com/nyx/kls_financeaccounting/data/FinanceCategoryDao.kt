package com.nyx.kls_financeaccounting.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nyx.kls_financeaccounting.FinanceCategory

@Dao
interface FinanceCategoryDao {
    @Query("SELECT * FROM finance_category")
    fun getCategories(): LiveData<List<FinanceCategory>>

    @Insert
    fun insertCategory(category: FinanceCategory)
}