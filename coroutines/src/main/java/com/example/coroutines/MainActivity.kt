package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    lateinit var coroutineScope: CoroutineScope
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
        button.setOnClickListener{
        }
        println("####執行coroutineScope之前"+Thread.currentThread().name)
        coroutineScope=object:CoroutineScope{
            override val coroutineContext: CoroutineContext=Job()

        }
        println("####執行launch之前"+Thread.currentThread().name)
        coroutineScope.launch(Dispatchers.Main) {

            println("####執行countNumber之前"+Thread.currentThread().name)
            async {countNumber(10)}
            delay(5000)
            async {countNumber2(10)}

            println("####執行countNumber之後"+Thread.currentThread().name)
        }

        println("####執行launch之後"+Thread.currentThread().name)

    }
    suspend fun countNumber(time:Int)= withContext(Dispatchers.Default){
        var i=0
        while(i++ < time){
            println("####countNumber現在數字=$i,"+Thread.currentThread().name)
            changeUi(i.toString())
            Thread.sleep(1000)

        }
    }
    suspend fun countNumber2(time:Int)= withContext(Dispatchers.IO){
        
        //a1
        //sl
        //a2

        var i=0
        while(i++ < time){
            println("####countNumber2現在數字=$i,"+Thread.currentThread().name)
            changeUi(i.toString())
            Thread.sleep(1000)
        }
    }
    suspend fun changeUi(text:String)= withContext(Dispatchers.Main){
        button.setText(text)
    }
}