package com.bear.testproductflavor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.commonutil.Util

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val money=money()
//        money.show()
        if(BuildConfig.isFree){

        }
        val util= Util()
        util.show()
    }
}