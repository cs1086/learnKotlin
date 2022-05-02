package com.bear.testtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_flavor.*

class ProductFlavorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_flavor)
        val repository= RepositoryData()
        val result=repository.getResult()
        productFlavorText.text=result

    }
}