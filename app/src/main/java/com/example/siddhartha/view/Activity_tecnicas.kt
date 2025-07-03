package com.example.siddhartha.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.siddhartha.ui.theme.SiddharthaTheme
import com.example.siddhartha.viewmodel.TecnicasViewModel

class Activity_tecnicas : ComponentActivity() {

    private val viewModel: TecnicasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mostrar interfaz
        setContent {
            SiddharthaTheme {
                TecnicasScaffold(viewModel)
            }
        }
    }
}
