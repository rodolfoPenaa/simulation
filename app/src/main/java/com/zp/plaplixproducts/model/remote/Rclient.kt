package com.zp.plaplixproducts.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class Rclient {
    companion object {
        private const val BASE_URL = "http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"
        fun retrofit_I(): PhoneAPI {
            val mretrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mretrofit.create(PhoneAPI::class.java)
        }
    }
}