package com.bear.testtdd.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bear.testtdd.R
import com.bear.testtdd.mvp.modle.ProductAPI
import com.bear.testtdd.mvp.modle.ProductResponse
import kotlinx.android.synthetic.main.activity_product.*
import java.text.NumberFormat

class ProductActivity : AppCompatActivity(), ProductContract.IProductView {
    private val productId = "pixel3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val productRepository = ProductRepository(ProductAPI())
        val productPresenter = ProductPresenter(this, productRepository)
        buy.setOnClickListener {
            val numbers = productItems.text.toString().toInt()
            productPresenter.buy(productId, numbers)
        }
        productPresenter.getProduct(productId)
    }

    override fun onGetResult(productResponse: ProductResponse) {
        productName.text = productResponse.name
        productDesc.text = productResponse.desc

        val currencyFormat = NumberFormat.getCurrencyInstance()
        currencyFormat.maximumFractionDigits = 0
        val price = currencyFormat.format(productResponse.price)
        productPrice.text = price
        println("####onGetResult=${productResponse.name}")
    }

    override fun onBuySuccess() {
        Toast.makeText(this, "購買成功", Toast.LENGTH_LONG).show();
        println("####onBuySuccess")
    }

    override fun onBuyFail() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("購買失敗").setTitle("錯誤")
        builder.show()
        println("####onBuyFail")
    }
}