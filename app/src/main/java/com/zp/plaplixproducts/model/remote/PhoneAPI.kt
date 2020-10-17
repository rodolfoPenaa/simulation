package com.zp.plaplixproducts.model.remote

import com.zp.plaplixproducts.model.CellPhone
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface PhoneAPI {
@GET("products/")
fun showPhones() : Call<List<CellPhone>>


@GET("details/{pID}")
fun productDetails(@Path("pID") pID:Int): Call<CellPhone>
}