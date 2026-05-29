package com.example.easybudgeting.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easybudgeting.data.model.Expense
import com.example.easybudgeting.data.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
) : ViewModel() {

    val allExpenses: StateFlow<List<Expense>> = expenseRepository.getAllExpenses()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.insertExpense(expense)
        }
    }

    fun updateExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.updateExpense(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.deleteExpense(expense)
        }
    }
}
