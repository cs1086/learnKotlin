package com.example.learnkotlin.ui_test

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.learnkotlin.R
import com.example.learnkotlin.imagepicker_drawView_timerView.MainActivity

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        var intent = Intent(this, MainActivity::class.java)
        var pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT)
        var builder: NotificationCompat.Builder
        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
            //IMPORTANCE_HIGH高會顯示出文字且震動 IMPORTANCE_DEFAULT會默默在導行列顯示小icon並震動 IMPORTANCE_LOW只會默默在導行列顯示小icon
            val channel=NotificationChannel("channel","mychannel",NotificationManager.IMPORTANCE_DEFAULT)
            val channel2=NotificationChannel("channel2","mychannel2",NotificationManager.IMPORTANCE_LOW)
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
        }
        builder=NotificationCompat.Builder(this,"channel").setSmallIcon(R.drawable.ic_baseline_soap_24).setContentTitle("my nofication").setContentText("my text").setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)).setVibrate(
            longArrayOf(300,600,300,600)).setLights(Color.GREEN,1000,1000).setContentIntent(pendingIntent).setAutoCancel(true)
        val nofication=builder.build()

        notificationManager.notify(100,nofication)
    }
}