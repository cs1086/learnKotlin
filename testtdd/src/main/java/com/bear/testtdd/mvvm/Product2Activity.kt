package com.bear.testtdd.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bear.testtdd.R
import com.bear.testtdd.databinding.ActivityProduct2Binding
import com.bear.testtdd.mvp.ProductRepository
import com.bear.testtdd.mvp.modle.ProductAPI

class Product2Activity : AppCompatActivity() {
    private val productId = "pixel3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product2)
        val dataBinding=DataBindingUtil.setContentView<ActivityProduct2Binding>(this,R.layout.activity_product2)
        val productAPI=ProductAPI()
        val productRepository=ProductRepository(productAPI)
        val productViewModel=ProductViewModel(productRepository)
        dataBinding.productViewModel=productViewModel
        dataBinding.lifecycleOwner=this
        productViewModel.getProduct(productId)
    }
}