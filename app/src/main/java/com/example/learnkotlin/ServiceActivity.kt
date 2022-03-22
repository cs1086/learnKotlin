package com.example.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        val button=findViewById<Button>(R.id.button5)
        //println("####ServiceActivity.${Thread.currentThread()}")
        val intent3 = Intent(this, MyService::class.java)
        startService(intent3)

        button.setOnClickListener {
            startService(intent3)
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