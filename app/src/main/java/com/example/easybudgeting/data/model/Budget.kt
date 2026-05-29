package com.example.easybudgeting.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets")
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val category: String,
    val budgetAmount: Double,
    val period: String, // "daily", "monthly", "yearly"
    val year: Int,
    val month: Int? = null,
    val day: Int? = null
)
