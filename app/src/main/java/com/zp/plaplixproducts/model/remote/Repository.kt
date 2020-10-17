package com.zp.plaplixproducts.model.remote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zp.plaplixproducts.model.CellPhone
import com.zp.plaplixproducts.model.local.LocalDDBB
import com.zp.plaplixproducts.model.local.PhoneDAO
import com.zp.plaplixproducts.model.local.ProductsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository(private val productsDAO: PhoneDAO, val context:Context) {

    private val retrofitC = Rclient.retrofit_I()
    private val stockProducts = productsDAO.getProducts()
    private val localDATA:LocalDDBB = LocalDDBB.getDDBB(context)


    var networkError = MutableLiveData<String>()
    var itemselected = 0

    fun remoteData(){
        retrofitC.showPhones().enqueue(object : Callback<List<CellPhone>>{
            override fun onResponse(
                call: Call<List<CellPhone>>,
                response: Response<List<CellPhone>>
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        localDATA.ddbb().availableProducts(toRoomConvert(it) as ArrayList<ProductsEntity>)
                    }
                }
            }
            override fun onFailure(call: Call<List<CellPhone>>, t: Throwable) {
            networkError.postValue(t.toString())
            }
        })
    }

    fun remoteDetails(){
        retrofitC.productDetails(itemselected)
    }

    fun toRoomConvert(listFromInternet: List<CellPhone>): List<ProductsEntity> {
        val listProductEntity = arrayListOf<ProductsEntity>()
        listFromInternet.map {
            listProductEntity.add(
                ProductsEntity(it.id,
                it.name,
                it.price,
                it.image)
            )
        }
        return listProductEntity
    }
}