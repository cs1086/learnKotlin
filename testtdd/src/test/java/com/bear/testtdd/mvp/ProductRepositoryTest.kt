package com.bear.testtdd.mvp

import argumentCaptor
import capture
import com.bear.testtdd.mvp.modle.IProductAPI
import com.bear.testtdd.mvp.modle.ProductResponse
import eq
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ProductRepositoryTest {
    lateinit var  productRepository:IProductRepository
    private var productResponse= ProductResponse()
    @Mock
    lateinit var productAPI:IProductAPI
    @Mock
    private lateinit var productRepositoryCallBack: IProductRepository.LoadProductCallback
    @Mock
    private lateinit var buyRepositoryCallBack: IProductRepository.BuyProductCallback
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        productRepository=ProductRepository(productAPI)
        productResponse.id = "pixel3"
        productResponse.name = "Google Pixel 3"
        productResponse.price = 27000
        productResponse.desc = "Desc"
    }
    @Test
    fun getProductTest(){
        val productId="pixel3"
        productRepository.getProduct(productId,productRepositoryCallBack)
        val loadAPICallBackCapter=argumentCaptor<IProductAPI.LoadAPICallBack>()
        verify(productAPI).getProduct(eq(productId),capture(loadAPICallBackCapter))
        loadAPICallBackCapter.value.onGetResult(productResponse)
        verify(productRepositoryCallBack).onProductResult(productResponse)
    }
    @Test
    fun buyTest(){
        val productId="pixel3"
        val amount=8
        productRepository.buy(productId,amount,buyRepositoryCallBack)
        verify(buyRepositoryCallBack).onBuyResult(true)
    }
}