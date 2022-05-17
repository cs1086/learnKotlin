package com.example.learnkotlin.service_test

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent

class MyJobService : JobService() {
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
    fun dosomething(){
        println("####service.dosomething")
    }
    override fun onUnbind(intent: Intent?): Boolean {
        println("####service.onUnbind")
        return super.onUnbind(intent)
    }
    var i=0
    override fun onStartJob(params: JobParameters?): Boolean {
//        Thread{
//            while(true){
//                Thread.sleep(1000)
//                println("####service.onStartCommand.Thread${i++}")
//            }
//        }.start()
        println("####service.onStartJob=${params?.extras?.getString("data")}")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        println("####service.onStopJob")
        return false
    }
}