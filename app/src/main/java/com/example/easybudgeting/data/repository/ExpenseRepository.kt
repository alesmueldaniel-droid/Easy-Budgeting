package com.example.easybudgeting.data.repository

import com.example.easybudgeting.data.database.ExpenseDao
import com.example.easybudgeting.data.model.Expense
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepository @Inject constructor(
    private val expenseDao: ExpenseDao
) {
    fun getAllExpenses(): Flow<List<Expense>> = expenseDao.getAllExpenses()

    fun getExpensesByType(type: String): Flow<List<Expense>> = expenseDao.getExpensesByType(type)

    fun getExpensesByCategory(category: String): Flow<List<Expense>> = expenseDao.getExpensesByCategory(category)

    fun getTotalExpensesByType(type: String): Flow<Double?> = expenseDao.getTotalExpensesByType(type)

    fun getTotalExpensesByCategoryAndType(category: String, type: String): Flow<Double?> =
        expenseDao.getTotalExpensesByCategoryAndType(category, type)

    suspend fun insertExpense(expense: Expense) = expenseDao.insertExpense(expense)

    suspend fun updateExpense(expense: Expense) = expenseDao.updateExpense(expense)

    suspend fun deleteExpense(expense: Expense) = expenseDao.deleteExpense(expense)
}
