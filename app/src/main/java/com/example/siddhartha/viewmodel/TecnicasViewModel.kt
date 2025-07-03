package com.example.siddhartha.viewmodel

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.siddhartha.R
import com.example.siddhartha.model.TecnicaData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TecnicasViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext

    private var _tecnicaActual = MutableStateFlow<TecnicaData?>(null)
    val tecnicaActual: StateFlow<TecnicaData?> = _tecnicaActual

    private var _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying

    var mediaPlayer: MediaPlayer? = null
        private set

    fun seleccionarTecnica(tecnica: TecnicaData) {
        releaseMediaPlayer()
        _tecnicaActual.value = tecnica
        mediaPlayer = MediaPlayer.create(context, tecnica.audioResId).apply {
            setOnCompletionListener {
                _isPlaying.value = false
            }
        }
    }

    fun playOrPause() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                _isPlaying.value = false
            } else {
                it.start()
                _isPlaying.value = true
            }
        }
    }

    fun reiniciar() {
        mediaPlayer?.seekTo(0)
        mediaPlayer?.start()
        _isPlaying.value = true
    }

    fun cerrarDialogo() {
        mediaPlayer?.pause()
        _isPlaying.value = false
        _tecnicaActual.value = null
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        _isPlaying.value = false
    }

    override fun onCleared() {
        super.onCleared()
        releaseMediaPlayer()
    }
}
