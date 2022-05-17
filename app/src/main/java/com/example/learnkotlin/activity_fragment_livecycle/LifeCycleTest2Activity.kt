package com.example.learnkotlin.activity_fragment_livecycle

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnkotlin.R

class LifeCycleTest2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_test2)
        println("####Activity2.onCreate")
    }
    override fun onStart() {
        println("####Activity2.onStart")
        super.onStart()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        println("####Activity2.onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }
    override fun onResume() {
        println("####Activity2.onResume")
        super.onResume()
    }
    override fun onPause() {
        println("####Activity2.onPause")
        super.onPause()
    }
    override fun onStop() {
        println("####Activity2.onStop")
        super.onStop()
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        println("####Activity2.onRestoreInstanceState")

        super.onRestoreInstanceState(savedInstanceState)
    }
    override fun onRestart() {
        println("####Activity2.onRestart")
        super.onRestart()
    }
    override fun onDestroy() {
        println("####Activity2.onDestroy")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        println("####Activity2.onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }
}