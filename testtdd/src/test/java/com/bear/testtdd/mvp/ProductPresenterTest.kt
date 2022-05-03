package com.bear.testtdd.mvp

import argumentCaptor
import capture
import com.bear.testtdd.mvp.modle.ProductResponse
import eq
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

class ProductPresenterTest{
    private lateinit var presenter:ProductContract.IProductPresenter
    private var productResponse=ProductResponse()
    @Mock
    private lateinit var repository: IProductRepository
    @Mock
    private lateinit var productView: ProductContract.IProductView
    @Before
    fun setupPresenter(){
        MockitoAnnotations.initMocks(this)
        presenter=ProductPresenter(productView,repository)
        productResponse.id = "pixel3"
        productResponse.name = "Google Pixel 3"
        productResponse.price = 27000
        productResponse.desc = "Desc"
    }
    @Test
    fun getProdcutTest(){
        val productId = "pixel3"
        //呼叫SUT
        presenter.getProduct(productId)
        val loadProductCallbackCapter = argumentCaptor<IProductRepository.LoadProductCallback>()
        //驗證是否有呼叫IProductRepository.getProduct
        verify(repository).getProduct(eq(productId),capture(loadProductCallbackCapter))
        //將callback攔截下載並指定productResponse的值。
        loadProductCallbackCapter.value.onProductResult(productResponse)
        //驗證是否有呼叫View.onGetResult及是否傳入productResponse
        verify(productView).onGetResult(productResponse)

    }
    @Test
    fun buySuccessTest() {
        val productId = "pixel3"
        val amount=8
        presenter.buy(productId,amount)
        val buyProductCallbackCapter=argumentCaptor<IProductRepository.BuyProductCallback>()
        //驗證是否有呼叫IProductRepository.buy
        verify(repository).buy(eq(productId),eq(amount),capture(buyProductCallbackCapter))
        //將callback攔截下載並指定productResponse的值。
        buyProductCallbackCapter.value.onBuyResult(true)
        verify(productView).onBuySuccess()
    }
    @Test
    fun buyFailTest() {
        val productId = "pixel3"
        val amount=8
        presenter.buy(productId,amount)
        val buyProductCallbackCapter=argumentCaptor<IProductRepository.BuyProductCallback>()
        //驗證是否有呼叫IProductRepository.buy
        verify(repository).buy(eq(productId),eq(amount),capture(buyProductCallbackCapter))
        //將callback攔截下載並指定productResponse的值。
        buyProductCallbackCapter.value.onBuyResult(false)
        verify(productView).onBuyFail()
    }
}