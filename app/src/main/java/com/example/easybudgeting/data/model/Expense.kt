package com.example.easybudgeting.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val description: String,
    val amount: Double,
    val category: String,
    val date: Long, // Unix timestamp
    val type: String, // "daily", "monthly", "yearly"
    val createdAt: Long = System.currentTimeMillis()
)
