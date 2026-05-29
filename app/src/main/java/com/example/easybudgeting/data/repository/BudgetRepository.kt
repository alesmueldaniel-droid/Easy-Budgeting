package com.example.easybudgeting.data.repository

import com.example.easybudgeting.data.database.BudgetDao
import com.example.easybudgeting.data.model.Budget
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val budgetDao: BudgetDao
) {
    fun getAllBudgets(): Flow<List<Budget>> = budgetDao.getAllBudgets()

    fun getBudgetsByPeriod(period: String): Flow<List<Budget>> = budgetDao.getBudgetsByPeriod(period)

    fun getBudgetByCategory(category: String): Flow<Budget?> = budgetDao.getBudgetByCategory(category)

    suspend fun insertBudget(budget: Budget) = budgetDao.insertBudget(budget)

    suspend fun updateBudget(budget: Budget) = budgetDao.updateBudget(budget)

    suspend fun deleteBudget(budget: Budget) = budgetDao.deleteBudget(budget)
}
