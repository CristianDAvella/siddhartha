package com.example.siddhartha.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.siddhartha.ui.theme.SiddharthaTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiddharthaTheme {
                RegisterScreen(onRegisterSuccess = {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                })
            }
        }
    }
} 