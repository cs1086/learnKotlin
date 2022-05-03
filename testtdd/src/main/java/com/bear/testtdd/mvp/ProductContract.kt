package com.bear.testtdd.mvp

import com.bear.testtdd.mvp.modle.ProductResponse

class ProductContract {
    interface IProductPresenter{
        //取得商品資料
        fun getProduct(productId:String)
        fun buy(productId: String, numbers: Int)
    }
    interface IProductView{
        //取得資料的Callback
        fun onGetResult(productResponse:ProductResponse)
        fun onBuySuccess()
        fun onBuyFail()
    }

}