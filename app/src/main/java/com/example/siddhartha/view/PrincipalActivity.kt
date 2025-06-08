package com.example.siddhartha.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.siddhartha.ui.theme.SiddharthaTheme
import androidx.compose.ui.unit.dp


class PrincipalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiddharthaTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar("MainActivity", this)
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Text(
                            text = "¡Bienvenido a la pantalla principal!",
                            modifier = Modifier.padding(16.dp)
                        )
                        // Aquí podrías cargar el contenido principal
                    }
                }
            }
        }
    }
}
