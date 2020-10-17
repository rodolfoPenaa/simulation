package com.zp.plaplixproducts.model.local

import androidx.room.Entity

@Entity(tableName = "details_product")
class PhoneEntity(val id:Int,
                  val name:String,
                  val price:Int,
                  val image:String,
                  val description:String,
                  val lastPrice:Int,
                  val credit:Boolean){
}