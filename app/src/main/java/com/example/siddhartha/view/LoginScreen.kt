package com.example.siddhartha.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.siddhartha.viewmodel.AuthViewModel
import com.example.siddhartha.R
import android.content.Intent
import androidx.compose.ui.platform.LocalContext


@Composable
fun LoginScreen(viewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)) {
            TextField(value = email, onValueChange = { email = it }, label = { Text(stringResource(R.string.email)) })
            TextField(value = password, onValueChange = { password = it }, label = { Text(stringResource(R.string.password)) }, visualTransformation = PasswordVisualTransformation())
            Button(onClick = { viewModel.login(email, password)
                val intent = Intent(context, PrincipalActivity::class.java)
                context.startActivity(intent)
                             }, colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.primary)) {


                Text(text = stringResource(R.string.login))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { viewModel.register(email, password) }, colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.secondary)) {
                Text(text = stringResource(R.string.register))
            }
        }
    }
}