package com.example.learnkotlin.menu.buttom_navigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.learnkotlin.R
import com.example.learnkotlin.databinding.ActivityButtomNavigationBinding


class ButtomNavigationActivity : AppCompatActivity() {

private lateinit var binding: ActivityButtomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = ActivityButtomNavigationBinding.inflate(layoutInflater)
         setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_buttom_navigation)
        //不推薦寫法
        //val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        //推薦寫法
        val appBarConfiguration = AppBarConfiguration(navView.menu)
        //讓左上角的actionBar跟著導航變動
        setupActionBarWithNavController(navController, appBarConfiguration)
        //讓menu按鈕可以有導航換頁功能
        navView.setupWithNavController(navController)
    }
}