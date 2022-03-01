package com.example.learnkotlin

import android.app.*
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat


class MyForegroundService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    override fun onCreate() {
        super.onCreate()
//       Thread(object :Runnable{
//            override fun run() {
//                var a=1
//                while(true){
//                    Thread.sleep(1000)
//                    println("你好${++a}")
//                }
//            }
//
//        }).start()
//        if (Build.VERSION.SDK_INT >= 26) {
//            val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                NotificationChannel(
//                    "id",
//                    "正在偷你的電電",
//                    NotificationManager.IMPORTANCE_DEFAULT
//                )
//            } else {
//                TODO("VERSION.SDK_INT < O")
//            }
//            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
//                channel
//            )
//        }
    }
//    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
//        val input = intent.getStringExtra("inputExtra")
//        val notificationIntent = Intent(this, MainActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(
//            this,
//            0, notificationIntent, 0
//        )
//        val notification: Notification = NotificationCompat.Builder(this, "id")
//            .setContentTitle("我正在偷你的電電!")
//            .setContentText(input)
//            .setSmallIcon(R.drawable.ball)
//            .setContentIntent(pendingIntent)
//            .build()
//        startForeground(1, notification)
//        return START_NOT_STICKY
//    }
}