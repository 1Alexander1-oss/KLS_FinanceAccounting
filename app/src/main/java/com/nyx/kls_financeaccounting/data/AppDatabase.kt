package com.nyx.kls_financeaccounting.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nyx.kls_financeaccounting.FinanceCategory

@Database(
    entities = [
        FinanceCategory::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): FinanceCategoryDao
}