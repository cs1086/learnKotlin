package com.example.learnkotlin.fcm

import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    lateinit var broadcastMangage : LocalBroadcastManager
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        broadcastMangage= LocalBroadcastManager.getInstance(this)
        val intent = Intent("CusMessage")
        intent.putExtra("from",remoteMessage.from.toString())
        if(remoteMessage.notification!=null){
            intent.putExtra("body",remoteMessage.notification?.body)
        }
        broadcastMangage.sendBroadcast(intent)
    }
}