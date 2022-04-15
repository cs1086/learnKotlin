package com.example.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TestVolatileActivity : AppCompatActivity() {
    var num=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_volatile)
        TestVolatile().test()
    }
}