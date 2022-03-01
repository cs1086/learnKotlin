package com.example.learnkotlin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
class WebViewActivity : AppCompatActivity() {
    var type=FragmentType.Home
    var manage=this.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        var bottomNavigationView:BottomNavigationView=findViewById(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    type = FragmentType.Home
                }
                R.id.navigation_notifications -> {
                    type = FragmentType.Notifications
                }
                R.id.navigation_dashboard -> {
                    type = FragmentType.Dashboard
                }
                R.id.pageview -> {
                    type = FragmentType.PageViewer
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }

            changeScenario()
            true
        }
        changeScenario()
        startService(Intent(this,MyForegroundService::class.java))

        //webView.loadUrl(URL)
    }
    fun changeScenario() {
        val transaction=manage.beginTransaction()
        when(type){
            FragmentType.Home ->{
                val homeFragment = HomeFragment()
                transaction.replace(R.id.container, homeFragment)
                Log.d(Companion.TAG, "changeScenario: 近來")
            }
            FragmentType.Notifications ->{
                val notificationFragment = NotificationFragment()
                transaction.replace(R.id.container, notificationFragment)
            }
            FragmentType.Dashboard ->{
                val dashboardFragment = DashboardFragment()
                transaction.replace(R.id.container, dashboardFragment)
            }
            FragmentType.PageViewer ->{
                val pageViewerFragment = PageViewerFragment()
                transaction.replace(R.id.container, pageViewerFragment)
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }

    enum class FragmentType{
        Home,
        Notifications,
        Dashboard,
        PageViewer
    }

    companion object {
        private const val TAG = "WebViewActivity"
    }


}