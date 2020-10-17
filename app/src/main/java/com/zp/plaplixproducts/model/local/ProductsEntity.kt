package com.zp.plaplixproducts.model.local

import androidx.room.Entity

@Entity(tableName = "all_products")
class ProductsEntity(val id:Int,
                     val name:String,
                     val price:Int,
                     val image:String) {

}