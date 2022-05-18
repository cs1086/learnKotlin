package com.example.learnkotlin.ui_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.learnkotlin.R

class ProgressControlActivity : AppCompatActivity() {
    lateinit var handler:Handler
    lateinit var runnable:Runnable
    lateinit var progressBar:ProgressBar
    lateinit var showNow:TextView
    lateinit var startButton:Button
    lateinit var stopButton:Button
    lateinit var pauseButton:Button


    var max=100
    var now=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_control)
        progressBar=findViewById(R.id.progressBar)
        progressBar.max=max
        showNow=findViewById(R.id.showNow)
        startButton=findViewById(R.id.start)
        stopButton=findViewById(R.id.stop)
        pauseButton=findViewById(R.id.pause)
        setUI()
        handler= Handler()
        runnable= Runnable {
            increaseProgress()
            handler.postDelayed(runnable,500)
        }
        startButton.setOnClickListener {
            runnable.run()
        }
        stopButton.setOnClickListener {
            stop()
        }
        pauseButton.setOnClickListener {
            pause()
        }

    }
    fun increaseProgress(){
        now=if(now<100)now+10 else 0
        setUI()
    }
    fun pause(){
        handler.removeCallbacksAndMessages(null)
    }
    fun stop(){
        pause()
        this.now = 0
        setUI()
    }
    fun setUI(){
        progressBar.progress=now
        showNow.text="${now}%"

    }
}