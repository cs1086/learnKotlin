package com.example.learnkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnkotlin.databinding.ActivityDeepLinkBinding
import com.example.learnkotlin.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textDeepLinkResult.text = getProductUrl()
    }
    private fun getProductUrl() = intent?.getStringExtra(EXTRA_PRODUCT_URL_KEY) ?: ""

    companion object {
        private const val EXTRA_PRODUCT_URL_KEY = "EXTRA_PRODUCT_URL_KEY"

        fun launch(context: Context, productUrl: String) {
            val intent = Intent(context, ProductActivity::class.java).apply {
                putExtra(EXTRA_PRODUCT_URL_KEY, productUrl)
            }
            context.startActivity(intent)
        }
    }
}