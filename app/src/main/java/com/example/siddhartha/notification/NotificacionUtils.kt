package com.example.siddhartha.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.siddhartha.R
import com.example.siddhartha.view.MainActivity

object NotificacionUtils {

    fun mostrarNotificacion(context: Context, titulo: String, mensaje: String) {
        Log.d("NotificacionUtils", "🚀 Notificación mostrada: $titulo - $mensaje")
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, "canal_relajacion")
            .setSmallIcon(R.drawable.ic_relax)
            .setContentTitle(titulo)
            .setContentText(mensaje)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1001, builder.build())
    }

    fun crearCanal(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Canal Relajación"
            val descriptionText = "Recordatorios de relajación"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("canal_relajacion", name, importance).apply {
                description = descriptionText
            }
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
