package com.example.siddhartha.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var authState = mutableStateOf(false)
        private set

    fun login(email: String, password: String) {
        authState.value = true
    }

    fun register(email: String, password: String) {
        authState.value = true
    }
}