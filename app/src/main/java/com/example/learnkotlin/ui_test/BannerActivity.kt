package com.example.learnkotlin.ui_test

import android.R
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.youth.banner.Banner
import com.youth.banner.loader.ImageLoader

class BannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.learnkotlin.R.layout.activity_banner)
        val banner = findViewById<View>(com.example.learnkotlin.R.id.banner) as Banner
        val images: ArrayList<String?> = ArrayList()

        //將想要輪播的廣告圖片網址新增
        images.add("https://i.ytimg.com/vi/HuhkUIYRryA/maxresdefault.jpg")
        images.add("https://mrmad.com.tw/wp-content/uploads/2021/03/apple-iphone-12-cook-and-fumble.jpg")
        banner.setImageLoader(GlideIamgeLoader())
        banner.setImages(images)
        //想要多久自動換頁
        banner.setDelayTime(3000)
        banner.start()
    }
    class GlideIamgeLoader : ImageLoader() {
        override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
            Glide.with(context).load(path).into(imageView)
        }
    }
}