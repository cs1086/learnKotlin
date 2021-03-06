package com.bear.testtdd.mvp

import com.bear.testtdd.mvp.modle.ProductResponse

class ProductPresenter(
    private val view: ProductContract.IProductView,
    private val productRepository: IProductRepository
) : ProductContract.IProductPresenter {
    override fun getProduct(productId: String) {
        productRepository.getProduct(productId, object : IProductRepository.LoadProductCallback {
            override fun onProductResult(productResponse: ProductResponse) {
                view.onGetResult(productResponse)
            }
        })
    }

    override fun buy(productId: String, numbers: Int) {
        productRepository.buy(productId, numbers, object : IProductRepository.BuyProductCallback {
            override fun onBuyResult(isSuccess: Boolean) {
                if (isSuccess) {
                    view.onBuySuccess()
                } else {
                    view.onBuyFail()
                }
            }

        })
    }

}