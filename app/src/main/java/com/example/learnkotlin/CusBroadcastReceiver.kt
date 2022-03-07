package com.example.learnkotlin

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class CusBroadcastReceiver(val ctx:Context) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        AlertDialog.Builder(ctx).setTitle(intent.getStringExtra("from")).setMessage(intent.getStringExtra("body")).show()
    }
}