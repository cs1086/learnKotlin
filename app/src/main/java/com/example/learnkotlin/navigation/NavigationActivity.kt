package com.example.learnkotlin.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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
        super.onResume()
    }
    override fun onSupportNavigateUp(): Boolean {
        val controller=findNavController(R.id.fragmentContainerView)
        return controller.navigateUp()
    }
}