package com.example.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var handler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        textView=findViewById(R.id.textView3)
        textView.setOnClickListener{
            handler.sendEmptyMessage(10)
        }
        val test=Test()
        println("####"+test.a.get())

        Thread{
            //Thread.sleep(4000)
            textView.post { println("####post") }
            Looper.prepare()
            handler = Handler(Looper.myLooper()!!,Handler.Callback {
                //textView.setText("2255")
                println("####Handler.Callback")
                Looper.myLooper()?.quit()
                //Looper.myLooper()?.quit()
                true
            })
            println("####loop")
            Looper.loop()

            runOnUiThread {
                println("####runOnUiThread")
            }
            println("####handler結束")
//            Looper.prepare()
//            Looper.loop()
            //test.a=5
            test.a.set(5)
            println("####"+test.a.get())
            //println("####"+test.a)
        }.start()
    }
    class Test(){
        //var a:Int=10
        var a:ThreadLocal<Int> = ThreadLocal<Int>()
        init {
            a.set(10)
        }
    }

}