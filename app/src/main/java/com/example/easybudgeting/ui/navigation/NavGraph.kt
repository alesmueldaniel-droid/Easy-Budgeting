package com.example.easybudgeting.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easybudgeting.ui.screens.HomeScreen
import com.example.easybudgeting.ui.screens.AddExpenseScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("add_expense") {
            AddExpenseScreen(navController = navController)
        }
    }
}
