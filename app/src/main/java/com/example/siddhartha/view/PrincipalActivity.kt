package com.example.siddhartha.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.siddhartha.ui.theme.SiddharthaTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.siddhartha.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.buddha),
                                contentDescription = stringResource(R.string.app_name),
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .padding(bottom = 24.dp)
                            )
                            Text(
                                text = stringResource(R.string.home_title),
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                ),
                                modifier = Modifier.padding(bottom = 24.dp)
                            )

                            SectionCard(title = stringResource(R.string.section_title_intro), content = stringResource(R.string.section_text_intro))

                            SectionCard(title = stringResource(R.string.section_title_history), content = stringResource(R.string.section_text_history))

                            SectionCard(title = stringResource(R.string.section_title_purpose), content = stringResource(R.string.section_text_purpose))

                            SectionCard(title = stringResource(R.string.section_title_benefits), content = stringResource(R.string.section_text_benefits))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SectionCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 22.sp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
