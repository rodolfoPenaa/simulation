package com.zp.plaplixproducts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zp.plaplixproducts.R
import com.zp.plaplixproducts.model.CellPhone


class ProductsAdapter(var mData:List<CellPhone>):RecyclerView.Adapter<ProductsAdapter.PhonesHolder>() {

    fun updateDATA(productsList:List<CellPhone>){
        mData = productsList
        notifyDataSetChanged()
    }

    inner class PhonesHolder(itemView:View):RecyclerView.ViewHolder(itemView){
     /*   val names = itemView.modelo
        val prices = itemView.precio
        val photo = itemView.telefono*/

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_products_list,parent,false)
        return PhonesHolder(view)
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {
        val phone:CellPhone = mData[position]
        val imagen = mData[position].image
/*
        Glide.with(holder.itemView.context).load(imagen).into(holder.photo)
*/
    }

    override fun getItemCount(): Int {
    return mData.size
    }

}