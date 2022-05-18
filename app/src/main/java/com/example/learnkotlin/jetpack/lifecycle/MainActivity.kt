package com.example.learnkotlin.jetpack.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnkotlin.R

class MainActivity : AppCompatActivity() {
    val chronometer:MyChronometer2 by lazy {
        findViewById(R.id.myChronometer)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        lifecycle.addObserver(chronometer)
    }
}