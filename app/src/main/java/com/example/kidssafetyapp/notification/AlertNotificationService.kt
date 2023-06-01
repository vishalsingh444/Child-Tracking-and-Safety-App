package com.example.kidssafetyapp.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.kidssafetyapp.MainActivity
import com.example.kidssafetyapp.R

class AlertNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun showNotification(){
        val activityIntent = Intent(context,MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.sos_48px)
            .setContentTitle("Alert!")
            .setContentText("Child in danger")
            .setVibrate(longArrayOf(100,200,300,400))
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(1,notification)
    }
    companion object{
        const val CHANNEL_ID = "alert_channel"
    }
}