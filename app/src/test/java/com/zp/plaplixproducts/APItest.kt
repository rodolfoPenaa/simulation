package com.zp.plaplixproducts

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.zp.plaplixproducts.model.local.ProductsEntity
import com.zp.plaplixproducts.model.remote.PhoneAPI
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APItest {

    lateinit var mMockWebServer: MockWebServer
    lateinit var productsAPI: PhoneAPI

    @Before
    fun setUp() {
        mMockWebServer = MockWebServer()
        val retrofitClient = Retrofit.Builder()
            .baseUrl(mMockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        productsAPI =  retrofitClient.create(productsAPI::class.java)
    }

    @After
    fun shutDown() {
        mMockWebServer.shutdown()
    }

    @Test
    fun getProductsStock() = runBlocking {
        val mresultList = listOf<ProductsEntity>(ProductsEntity(10,
            "LG Q6 32GB",
            107760,
            "https://www.lg.com/us/images/cell-phones/md05902196/gallery/medium05.jpg"))
        mMockWebServer.enqueue(MockResponse().setBody(Gson().toJson(mresultList)))
        val result = productsAPI.showPhones()
        assertThat(result).isNotNull()
}
}