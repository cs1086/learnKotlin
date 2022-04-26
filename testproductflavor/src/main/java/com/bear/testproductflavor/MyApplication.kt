package com.bear.testproductflavor

import android.app.Application
import com.example.commonutil.MyApplication2

class MyApplication: Application() {
    companion object{
        var isFree = BuildConfig.isFree
    }
    init {
        MyApplication2.isFree=BuildConfig.isFree
        println("####testproductflavor.MyApplication")
    }
}