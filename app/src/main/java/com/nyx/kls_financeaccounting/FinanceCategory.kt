package com.nyx.kls_financeaccounting

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "finance_category")
data class FinanceCategory(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val ratio: Double,
)
