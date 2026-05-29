package com.example.easybudgeting.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AddExpenseScreen(navController: NavHostController) {
    val description = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val category = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Tambah Pengeluaran") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = description.value,
                onValueChange = { description.value = it },
                label = { Text("Deskripsi") },
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = amount.value,
                onValueChange = { amount.value = it },
                label = { Text("Jumlah") },
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = category.value,
                onValueChange = { category.value = it },
                label = { Text("Kategori") },
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { navController.popBackStack() }
            ) {
                Text("Simpan")
            }
        }
    }
}
