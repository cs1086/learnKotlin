package com.example.learnkotlin.fcm

import android.content.BroadcastReceiver
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.learnkotlin.R

class FCMActivity : AppCompatActivity() {
    lateinit var localBroadCastManager:LocalBroadcastManager
    lateinit var broadcastReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcmactivity)
        localBroadCastManager= LocalBroadcastManager.getInstance(this)
        broadcastReceiver= CusBroadcastReceiver(this)

    }

    override fun onResume() {
        localBroadCastManager.registerReceiver(broadcastReceiver, IntentFilter("CusMessage"))
        super.onResume()
    }

    override fun onPause() {
        localBroadCastManager.unregisterReceiver(broadcastReceiver)
        super.onPause()
    }
}