package com.bear.testtdd.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.bear.testtdd.mvp.IProductRepository
import com.bear.testtdd.mvp.ProductRepository
import com.bear.testtdd.mvp.modle.ProductResponse

class ProductViewModel(val productRepository:ProductRepository) {
    var productName:ObservableField<String> = ObservableField("")
    var productDesc:ObservableField<String> = ObservableField("")
    var productPrice:MutableLiveData<Int> = MutableLiveData(0)
    var productItems:ObservableField<String> = ObservableField("0")
    var productTotal:MutableLiveData<String> = MutableLiveData("0")
    fun getProduct(productId:String){
        productRepository.getProduct(productId,object :IProductRepository.LoadProductCallback{
            override fun onProductResult(productResponse: ProductResponse) {
                productName.set(productResponse.name)
                productDesc.set(productResponse.desc)
                productPrice.value=productResponse.price
            }
        })
    }
    fun getTotal():MutableLiveData<String>{
        var item=0
        if(!productItems.equals("")){
            item=productItems.get()!!.toInt()
        }
        productTotal.value=(productPrice.value!!*item).toString()
        return productTotal
    }
    fun buy(){
        println("####buy")
    }
}