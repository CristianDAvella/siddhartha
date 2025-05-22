package com.example.siddhartha.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SiddharthaTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = Color(0xFF9520d4),
        secondary = Color(0xFF20d495),
        tertiary = Color(0xFFd49520),
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFFFFFF),
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}