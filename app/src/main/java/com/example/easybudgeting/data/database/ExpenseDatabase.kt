package com.example.easybudgeting.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.easybudgeting.data.model.Budget
import com.example.easybudgeting.data.model.Expense

@Database(
    entities = [Expense::class, Budget::class],
    version = 1,
    exportSchema = false
)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun budgetDao(): BudgetDao
}
