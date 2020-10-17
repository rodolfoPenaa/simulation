package com.zp.plaplixproducts.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zp.plaplixproducts.model.CellPhone

class ProductsAdapter(var mDATAset: List<CellPhone>):RecyclerView.Adapter<ProductsAdapter.PhonesHolder>(){

    inner class PhonesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameText = itemView.phoneModel
        val appearencia = itemView.price
        val pngPhoto = itemView.ilustration
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}