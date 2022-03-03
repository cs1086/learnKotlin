package com.example.learnkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.learnkotlin.databinding.ActivityDeepLinkBinding
//測試deeplink
//電腦開啟adb輸入adb shell am start -W -a android.intent.action.VIEW -d "https://m.kkday.com/zh-tw/product/7317" com.example.learnkotlin 會自動開啟 或者在Line隨便一個好友聊天頻道輸入https://m.kkday.com/zh-tw/product/7317後點開也可以觸發
class DeepLinkActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDeepLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeepLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_deep_link)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        Handler().postDelayed({
            intent?.dataString?.let {
                parseDeepLink(Uri.parse(it))
            }
        }, 1500)
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    private fun parseDeepLink(uri: Uri) {
        // Parsing the uri which your received, the following is a simple regex
        if (uri.toString().matches(DEEP_LINK_URL_PATTERN.toRegex())) {
            ProductActivity.launch(this, uri.toString())
        }
    }
    companion object {
        private const val KKDAY_HOST_PATTERN = ".*kkday\\.com\\/.*\\/"
        private const val PATH_PATTERN = "product\\/"
        private const val DEEP_LINK_PRODUCT_INFO_PATTERN = "(" + "([0-9]+)" + ")"
        private const val DEEP_LINK_URL_PATTERN =
            KKDAY_HOST_PATTERN + PATH_PATTERN + DEEP_LINK_PRODUCT_INFO_PATTERN
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_deep_link)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}