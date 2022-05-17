package com.example.learnkotlin.java_function.volatile_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnkotlin.R

class TestVolatileActivity : AppCompatActivity() {
    var num=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_volatile)
        TestVolatile().test()
    }
}