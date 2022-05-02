package com.bear.testtdd.mvp

import java.net.CacheResponse

class ProductRepository {

}
interface IProductRepository{
    fun getProduct(productId:String,loadProductCallback:LoadProductCallback)
    interface LoadProductCallback{
        fun onProductResult(productResponse: ProductResponse)
    }
}