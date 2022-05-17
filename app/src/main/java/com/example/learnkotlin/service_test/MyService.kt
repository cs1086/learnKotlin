package com.example.learnkotlin.service_test

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.*
import androidx.core.app.NotificationCompat
import com.example.learnkotlin.imagepicker_drawView_timerView.MainActivity
import com.example.learnkotlin.R
import java.util.*

class MyService : Service() {
    lateinit var timer:Timer
    var i=0
    override fun onCreate() {
        println("####service.onCreate")
        timer=Timer()
        var intent = Intent(this, MainActivity::class.java)
        var pendingIntent= PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_CANCEL_CURRENT)
        var builder: NotificationCompat.Builder
        val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.O){
            //setChannelId 要寫且要指定要使用哪個channel的id 否則不會顯示notification
            builder=NotificationCompat.Builder(this,"100").setSmallIcon(R.drawable.ic_baseline_soap_24).setContentTitle("my nofication").setContentText("my text").setSound(
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)).setVibrate(
                longArrayOf(300,600,300,600)).setLights(Color.GREEN,1000,1000).setContentIntent(pendingIntent).setAutoCancel(true).setChannelId("channel2")
            val channel= NotificationChannel("channel","mychannel", NotificationManager.IMPORTANCE_HIGH)
            val channel2= NotificationChannel("channel2","mychannel2", NotificationManager.IMPORTANCE_LOW)
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
        }else{
            val notification=NotificationCompat.Builder(this, "100")
            builder=notification.setSmallIcon(R.drawable.ic_baseline_soap_24).setContentTitle("my nofication").setContentText("my text")
        }
        val nofication=builder.build()
        startForeground(1,nofication)
        super.onCreate()
    }
    override fun onDestroy() {
        println("####service.onDestroy")
        super.onDestroy()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        println("####service.onStart")
        super.onStart(intent, startId)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("####service.onStartCommand${Thread.currentThread()}")
        //stopSelf()
        Thread{
            Thread.sleep(3000)
//            while(true){
//                Thread.sleep(1000)
//                println("####service.onStartCommand.Thread${i++}")
//            }

            //println("####service.onStartCommand.Thread")
        }.start()
//        timer.schedule(object:TimerTask(){
//            override fun run() {
//                println("####service.TimerTask${i++}")
//            }
//
//        },0,1000)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        println("####service.onBind")
        return MyBind()
    }
    fun dosomething(){
        println("####service.dosomething")
    }
    override fun onUnbind(intent: Intent?): Boolean {
        println("####service.onUnbind")
        return super.onUnbind(intent)
    }
    inner class MyBind: Binder(){
        fun getService()=this@MyService
    }
}