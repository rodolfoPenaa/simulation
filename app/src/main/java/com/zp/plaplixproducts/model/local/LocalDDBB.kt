package com.zp.plaplixproducts.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ProductsEntity::class, PhoneEntity::class], version = 1, exportSchema = false)
abstract class LocalDDBB:RoomDatabase() {
    abstract fun ddbb(): PhoneDAO
    companion object{
        @Volatile
        private var mdata: LocalDDBB? = null
        fun getDDBB(context: Context): LocalDDBB {
            if (mdata ==null) synchronized(this){
                mdata =Room.databaseBuilder(context.applicationContext,
                    LocalDDBB::class.java,
                    "shopping_box").build()
            }
            return mdata!!
        }
    }
}