package com.example.siddhartha.view

import com.example.siddhartha.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import com.example.siddhartha.ui.theme.SiddharthaTheme

class Activity_tecnicas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiddharthaTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar("SecondActivity", this)
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        TecnicasScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun TecnicasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Técnicas de Relajación",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        Image(
            painter = painterResource(id = R.drawable.meditacion),
            contentDescription = "Imagen de meditación",
            modifier = Modifier
                .size(180.dp) // Use .size for circular images to ensure width and height are equal
                .clip(CircleShape) // Apply the circular clip
                .border(2.dp, Color.Gray, CircleShape) // Optional: Add a border around the circular image
                .padding(bottom = 24.dp),
            alpha = 0.9f
        )

        TecnicaButton(
            text = "Respiración profunda",
            borderColor = Color.Black
        ) {
            // Acción al pulsar el botón
        }

        TecnicaButton(
            text = "Relajación muscular",
            borderColor = Color.Black
        ) {
            // Acción al pulsar el botón
        }

        TecnicaButton(
            text = "Visualización guiada",
            borderColor = Color.Black
        ) {
            // Acción al pulsar el botón
        }
    }
}

@Composable
fun TecnicaButton(text: String, borderColor: Color, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(55.dp)
            .clickable(onClick = onClick)
            .background(color = Color.White, shape = RoundedCornerShape(50))
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(50))
            .padding(start = 24.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}