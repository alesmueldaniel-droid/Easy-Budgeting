package com.example.easybudgeting.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easybudgeting.data.model.Budget
import com.example.easybudgeting.data.repository.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository
) : ViewModel() {

    val allBudgets: StateFlow<List<Budget>> = budgetRepository.getAllBudgets()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addBudget(budget: Budget) {
        viewModelScope.launch {
            budgetRepository.insertBudget(budget)
        }
    }

    fun updateBudget(budget: Budget) {
        viewModelScope.launch {
            budgetRepository.updateBudget(budget)
        }
    }

    fun deleteBudget(budget: Budget) {
        viewModelScope.launch {
            budgetRepository.deleteBudget(budget)
        }
    }
}
