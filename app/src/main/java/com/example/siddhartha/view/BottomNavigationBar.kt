package com.example.siddhartha.view

import android.content.Context
import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List

import androidx.compose.material3.*
import androidx.compose.runtime.Composable






@Composable
fun BottomNavigationBar(currentActivity: String, context: Context) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentActivity == "MainActivity",
            onClick = {
                if (currentActivity != "MainActivity") {
                    context.startActivity(Intent(context, PrincipalActivity::class.java))
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Second") },
            label = { Text("Second") },
            selected = currentActivity == "SecondActivity",
            onClick = {
                if (currentActivity != "SecondActivity") {
                    context.startActivity(Intent(context, Activity_tecnicas::class.java))
                }
            }
        )
       /* NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Third") },
            label = { Text("Third") },
            selected = currentActivity == "ThirdActivity",
            onClick = {
                if (currentActivity != "ThirdActivity") {
                    context.startActivity(Intent(context, ThirdActivity::class.java))
                }
            }
        )*/
    }
}
