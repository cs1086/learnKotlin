package com.example.learnkotlin.service_test

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService

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
            enqueueWork(context, MyJobIntentService::class.java,1011,intent)
            println("####service.dosomething")

        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("####service.onUnbind")
        return super.onUnbind(intent)
    }
}