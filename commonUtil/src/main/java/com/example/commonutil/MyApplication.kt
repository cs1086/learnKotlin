package com.example.commonutil

import android.app.Application

class MyApplication2: Application() {
    companion object{
        var isFree = false
    }
    init {
        println("####commonutil.MyApplication")
    }
}