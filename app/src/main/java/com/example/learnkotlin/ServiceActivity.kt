package com.example.learnkotlin

import android.app.Service
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.util.TimeUtils
import android.widget.Button

class ServiceActivity : AppCompatActivity() {
    lateinit var myservice:MyService
    val serviceConnection=object:ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myservice=(service as MyService.MyBind).getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        val button=findViewById<Button>(R.id.button5)
        //println("####ServiceActivity.${Thread.currentThread()}")
        //val intent3 = Intent(this, Service::class.java)
        //startService(intent3)
        //bindService(intent3,serviceConnection, Context.BIND_AUTO_CREATE)

//        val jobScheduler=getSystemService(Context.JOB_SCHEDULER_SERVICE)as JobScheduler
//        val jobInfo= JobInfo.Builder(1, ComponentName(this,MyJobService::class.java))
//        jobInfo.setMinimumLatency(1000)
//        var bundle=PersistableBundle()
//        bundle.putString("data","王柏榕")
//        jobInfo.setExtras(bundle)
//        jobScheduler.schedule(jobInfo.build())

        val intent4 = Intent().apply {
            putExtra("data","王柏榕")

        }
        MyJobIntentService.enqueueWork(this,intent4)

        button.setOnClickListener {
//            jobScheduler.cancel(1)

//            myservice.dosomething()
//            unbindService(serviceConnection)
            //stopService(intent3)
            //startService(intent3)
//            val intent2 = Intent(this, MyIntentService::class.java).apply {
//                action = "com.example.learnkotlin.action.FOO"
//                putExtra("com.example.learnkotlin.extra.PARAM1", "data1")
//                putExtra("com.example.learnkotlin.extra.PARAM2", "data2")
//            }
//            startService(intent2)
        }
//        val intent2 = Intent(this, MyIntentService::class.java).apply {
//            action = "com.example.learnkotlin.action.FOO"
//            putExtra("com.example.learnkotlin.extra.PARAM1", "data1")
//            putExtra("com.example.learnkotlin.extra.PARAM2", "data2")
//        }
//        startService(intent2)
//        val intent = Intent(this, MyIntentService2::class.java).apply {
//            action = "com.example.learnkotlin.action.BAZ"
//            putExtra("com.example.learnkotlin.extra.PARAM1", "data1")
//            putExtra("com.example.learnkotlin.extra.PARAM2", "data2")
//
//        }
//        startService(intent)
//        Thread{
//            println("####Thread.${Thread.currentThread()}")
//            Thread{
//                println("####Thread2.${Thread.currentThread()}")
//            }.start()
//        }.start()

//        MyIntentService.startActionBaz(this,"data1","data2")
//        MyIntentService.startActionFoo(this,"data3","data4")
//        MyIntentService.startActionBaz(this,"data5","data6")
//        MyIntentService.startActionFoo(this,"data7","data8")

        println("####onCreate")
    }
}