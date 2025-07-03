package com.example.siddhartha.view

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(currentActivity: String, context: Context) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.tertiary,
        tonalElevation = 8.dp
    ) {
        /*NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = "About") },
            label = { Text("About") },
            selected = currentActivity == "AboutActivity",
            onClick = {
                if (currentActivity != "AboutActivity") {
                    context.startActivity(Intent(context, PrincipalActivity::class.java))
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )*/

        NavigationBarItem(
            icon = { Icon(Icons.Default.Star, contentDescription = "Técnicas") },
            label = { Text("Técnicas") },
            selected = currentActivity == "SecondActivity",
            onClick = {
                if (currentActivity != "SecondActivity") {
                    context.startActivity(Intent(context, Activity_tecnicas::class.java))
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Inicio") },
            selected = currentActivity == "MainActivity",
            onClick = {
                if (currentActivity != "MainActivity") {
                    context.startActivity(Intent(context, PrincipalActivity::class.java))
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                selectedTextColor = Color.Black,
                indicatorColor = MaterialTheme.colorScheme.surface
            )
        )
    }
}
