package com.bear.testtdd.mvp.modle

import android.os.Looper
import java.util.logging.Handler

interface IProductAPI {
    interface LoadAPICallBack{
        fun onGetResult(productResponse: ProductResponse)
    }
    fun getProduct(productId:String,productDataCallback:LoadAPICallBack)
}
class ProductAPI:IProductAPI {
    override fun getProduct(
        productId: String,
        productDataCallback: IProductAPI.LoadAPICallBack
    ) {
        val handler=android.os.Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            val productResponse = ProductResponse()
            productResponse.id = "pixel3"
            productResponse.name = "Google Pixel 3"
            productResponse.desc = "5.5吋螢幕"
            productResponse.price = 27000
            productDataCallback.onGetResult(productResponse)
        },1000)
    }
}