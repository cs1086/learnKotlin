package com.example.learnkotlin.navigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.learnkotlin.R


class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        //有錯誤
//        val controller=findNavController(R.id.fragmentContainerView)
//        NavigationUI.setupActionBarWithNavController(this,controller)
        //解決錯誤
//        val navigationHost =
//            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        val controller = navigationHost.navController
//        NavigationUI.setupActionBarWithNavController(this,controller)
    }

    override fun onResume() {
        val controller=findNavController(R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this,controller)

        sendNotification()
        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        val controller=findNavController(R.id.fragmentContainerView)
        return controller.navigateUp()
    }
    private fun sendNotification() {
        if (this == null) {
            return
        }
        val CHANNEL_ID="nav_fragment"
        val notificationId=1
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, "ChannelName", importance)
            channel.description = "description"
            val notificationManager: NotificationManager = this.getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("DeepLinkDemo")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(getPendingIntent()) //设置PendingIntent
            .setAutoCancel(true)
        val notificationManager: NotificationManagerCompat =
            NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, builder.build())
    }
    private fun getPendingIntent(): PendingIntent? {
        if (this != null) {
            val bundle = Bundle()
            bundle.putString("params", "from Notification")
            //寫法1
            return findNavController(R.id.fragmentContainerView)
                .createDeepLink()
                .setGraph(R.navigation.my_nav_graph)
                .setDestination(R.id.navigationFragment1)
                .setArguments(bundle)
                .createPendingIntent()
            //寫法2
//            return NavDeepLinkBuilder(this)
//                .setGraph(R.navigation.my_nav_graph)
//                .setDestination(R.id.navigationFragment1)
//                .setArguments(bundle)
//                .createPendingIntent()
        }
        return null
    }
}