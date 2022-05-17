package com.example.learnkotlin.service_test

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.IBinder

// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.example.learnkotlin.action.FOO"
private const val ACTION_BAZ = "com.example.learnkotlin.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.example.learnkotlin.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.learnkotlin.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.

 */
class MyIntentService : IntentService("MyIntentService") {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("####service.onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onHandleIntent(intent: Intent?) {
        println("####service.onHandleIntent")
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionFoo(param1, param2)
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionBaz(param1, param2)
            }
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("####service.onBind")
        return super.onBind(intent)
    }

    override fun onCreate() {
        println("####service.onCreate")
        super.onCreate()
    }
    override fun onStart(intent: Intent?, startId: Int) {
        println("####service.onStart")
        super.onStart(intent, startId)
    }
    override fun onUnbind(intent: Intent?): Boolean {
        println("####service.onUnbind")
        return super.onUnbind(intent)
    }
    override fun onDestroy() {
        println("####service.onDestroy")
        super.onDestroy()
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String?, param2: String?) {
        Thread.sleep(3000)
        //println("####${Thread.currentThread()}")

    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String?, param2: String?) {
        Thread.sleep(3000)
        //println("####${Thread.currentThread()}")
    }

    companion object {
        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        //@JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        /**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        // TODO: Customize helper method
        //@JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}