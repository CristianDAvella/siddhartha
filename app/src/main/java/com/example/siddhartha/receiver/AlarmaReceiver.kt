package com.example.siddhartha.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.siddhartha.notification.NotificacionUtils
import android.util.Log
import com.example.siddhartha.alarm.NotificacionAlarm

class AlarmaReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "com.example.siddhartha.ALARMA_DIARIA") {
            val hora = java.text.SimpleDateFormat("HH:mm:ss").format(java.util.Date())
            Log.d("AlarmaReceiver", "⏰ Alarma recibida a las $hora")

            NotificacionUtils.mostrarNotificacion(
                context,
                "Técnica de relajación",
                "¿Ya respiraste profundo hoy?"
            )
        } else if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d("AlarmaReceiver", "📦 Dispositivo reiniciado y tarea reprogramada")
            NotificacionAlarm.programarAlarmaDiaria(context)
        }
    }
}
