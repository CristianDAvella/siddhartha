package com.example.siddhartha.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.siddhartha.ui.theme.SiddharthaTheme
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.foundation.border // Import for border
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SiddharthaTheme {
                TecnicasScreen()
            }
        }
    }
}

@Composable
fun TecnicaButton(text: String, borderColor: Color, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.CenterStart, // This is the correct alignment
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(55.dp)
            .clickable(onClick = onClick)
            .background(color = Color.White, shape = RoundedCornerShape(50))
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(50))
            .padding(start = 24.dp) // Add horizontal padding to align text
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun TecnicasScreen() {
    var selectedItem by remember { mutableStateOf(1) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio") },
                    selected = selectedItem == 0,
                    onClick = { selectedItem = 0 /* Aquí puedes navegar */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Técnicas") },
                    label = { Text("Técnicas") },
                    selected = selectedItem == 1,
                    onClick = { selectedItem = 1 }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = selectedItem == 2,
                    onClick = { selectedItem = 2 /* Aquí puedes navegar */ }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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
                    .height(180.dp)
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                alpha = 0.9f // Valor entre 0.0 (transparente) y 1.0 (opaco)
            )



            TecnicaButton(
                text = "Respiración profunda",
                borderColor = Color(0xFF000000)
            ) {

            }
            TecnicaButton(
                text = "Relajación muscular",
                borderColor = Color(0xFF000000)
            ) {
                // Acción al hacer clic
            }
            TecnicaButton(
                text = "Visualización guiada",
                borderColor = Color(0xFF000000)
            ) {
            }
        }
    }
}