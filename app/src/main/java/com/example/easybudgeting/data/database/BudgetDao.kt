package com.example.easybudgeting.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.easybudgeting.data.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Insert
    suspend fun insertBudget(budget: Budget)

    @Update
    suspend fun updateBudget(budget: Budget)

    @Delete
    suspend fun deleteBudget(budget: Budget)

    @Query("SELECT * FROM budgets ORDER BY category")
    fun getAllBudgets(): Flow<List<Budget>>

    @Query("SELECT * FROM budgets WHERE period = :period")
    fun getBudgetsByPeriod(period: String): Flow<List<Budget>>

    @Query("SELECT * FROM budgets WHERE category = :category")
    fun getBudgetByCategory(category: String): Flow<Budget?>
}
