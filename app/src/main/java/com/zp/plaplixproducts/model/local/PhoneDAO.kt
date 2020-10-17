package com.zp.plaplixproducts.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PhoneDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun availableProducts(stockList:ArrayList<ProductsEntity>)

    @Query("SELECT * FROM all_products")
    fun getProducts():LiveData<List<ProductsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun detailing(selectionedPhone: PhoneEntity)

    @Query("SELECT * FROM details_product")
    fun getPreviusDetails():LiveData<List<PhoneEntity>>

}