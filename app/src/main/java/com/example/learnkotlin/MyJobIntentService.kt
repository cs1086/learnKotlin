package com.example.learnkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.*
import androidx.core.app.JobIntentService
import androidx.core.app.NotificationCompat
import java.io.FileDescriptor
import java.util.*

class MyJobIntentService : JobIntentService() {
    override fun onCreate() {
        println("####service.onCreate")
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
         //   Thread.sleep(3000)


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
    var i=0
    override fun onHandleWork(intent: Intent) {
        println("####service.onHandleWork")
//        while(true){
//            Thread.sleep(1000)
//            println("####service.onHandleWork.Thread${i++}")
//        }
    }
    companion object{
        fun enqueueWork(context: Context,intent: Intent){
            enqueueWork(context,MyJobIntentService::class.java,1011,intent)
            println("####service.dosomething")

        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("####service.onUnbind")
        return super.onUnbind(intent)
    }
}