package com.example.siddhartha.view

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collect
import androidx.compose.runtime.collectAsState
import com.example.siddhartha.viewmodel.AuthViewModel

@Composable
fun SiddhartaApp() {
    val viewModel: AuthViewModel = viewModel()
    val authState by viewModel.authState.collectAsState()

    if (!authState) {
        LoginScreen()
    } else {
        Scaffold {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                color = MaterialTheme.colorScheme.background
            ) {
                Text("Bienvenido a Siddharta", modifier = Modifier.padding(16.dp))
            }
        }
    }
}
