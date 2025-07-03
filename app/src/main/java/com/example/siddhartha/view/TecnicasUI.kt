package com.example.siddhartha.view

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.siddhartha.R
import com.example.siddhartha.model.TecnicaData
import com.example.siddhartha.viewmodel.TecnicasViewModel
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SelfImprovement
@Composable
fun TecnicasScreen(viewModel: TecnicasViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.relaxation_techniques), fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Image(
            painter = painterResource(id = R.drawable.meditacion),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .padding(bottom = 24.dp)
        )

        // Botón 1: Respiración profunda
        val nombre1 = stringResource(R.string.deep_breathing)
        val descripcion1 = stringResource(R.string.desc_deep_breathing)
        TecnicaButton(nombre1, Color.Black) {
            viewModel.seleccionarTecnica(
                TecnicaData(
                    nombre = nombre1,
                    descripcion = descripcion1,
                    audioResId = R.raw.respiracion_profunda,
                    lottieAsset = "breathing.json"
                )
            )
        }

        // Botón 2: Relajación muscular
        val nombre2 = stringResource(R.string.muscle_relaxation)
        val descripcion2 = stringResource(R.string.desc_muscle_relaxation)
        TecnicaButton(nombre2, Color.Black) {
            viewModel.seleccionarTecnica(
                TecnicaData(
                    nombre = nombre2,
                    descripcion = descripcion2,
                    audioResId = R.raw.escaneo_corporal,
                    lottieAsset = "muscular.json"
                )
            )
        }

        // Botón 3: Visualización guiada
        val nombre3 = stringResource(R.string.guided_visualization)
        val descripcion3 = stringResource(R.string.desc_guided_visualization)
        TecnicaButton(nombre3, Color.Black) {
            viewModel.seleccionarTecnica(
                TecnicaData(
                    nombre = nombre3,
                    descripcion = descripcion3,
                    audioResId = R.raw.meditacion_visualizada,
                    lottieAsset = "visualizacion.json"
                )
            )
        }
    }
}


@Composable
fun TecnicasScaffold(viewModel: TecnicasViewModel) {
    val isPlaying by viewModel.isPlaying.collectAsState()
    val tecnicaDialog by viewModel.tecnicaActual.collectAsState()

    Scaffold(
        bottomBar = {
            if (isPlaying) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD0F0FF))
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(R.string.playing_audio), fontSize = 14.sp)
                }
            }
            BottomNavigationBar("Activity_tecnicas", LocalContext.current)
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            TecnicasScreen(viewModel)
        }
    }

    tecnicaDialog?.let { tecnica ->
        TecnicaDialog(
            onDismiss = { viewModel.cerrarDialogo() },
            nombre = tecnica.nombre,
            descripcion = tecnica.descripcion,
            lottieAsset = tecnica.lottieAsset,
            mediaPlayer = viewModel.mediaPlayer,
            isPlaying = isPlaying,
            setIsPlaying = {
                if (it) viewModel.reiniciar()
                else viewModel.playOrPause()
            }
        )
    }
}

@Composable
fun TecnicaDialog(
    onDismiss: () -> Unit,
    nombre: String,
    descripcion: String,
    lottieAsset: String,
    mediaPlayer: MediaPlayer?,
    isPlaying: Boolean,
    setIsPlaying: (Boolean) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = nombre, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = descripcion, modifier = Modifier.padding(bottom = 8.dp))
                LottiePlayer(isPlaying = isPlaying, lottieAsset = lottieAsset)
            }
        },
        confirmButton = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = {
                        mediaPlayer?.seekTo(0)
                        mediaPlayer?.start()
                        setIsPlaying(true)
                    }) {
                        Text(stringResource(R.string.restart))
                    }
                    Button(onClick = {
                        if (mediaPlayer?.isPlaying == true) {
                            mediaPlayer.pause()
                            setIsPlaying(false)
                        } else {
                            mediaPlayer?.start()
                            setIsPlaying(true)
                        }
                    }) {
                        Text(
                            text = if (isPlaying)
                                stringResource(R.string.pause)
                            else
                                stringResource(R.string.play)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(onClick = {
                    mediaPlayer?.pause()
                    setIsPlaying(false)
                    onDismiss()
                }) {
                    Text(stringResource(R.string.close))
                }
            }
        },
        dismissButton = {}
    )
}

@Composable
fun LottiePlayer(isPlaying: Boolean, lottieAsset: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(lottieAsset))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(200.dp)
    )
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
            fontSize = 16.sp
        )
    }
}
