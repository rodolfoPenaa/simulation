package com.zp.plaplixproducts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zp.plaplixproducts.R
import com.zp.plaplixproducts.model.CellPhone

class ProductsAdapter(private var mDATAset: List<CellPhone>):RecyclerView.Adapter<ProductsAdapter.PhonesHolder>(){


    fun updateDataset(phoneList:List<CellPhone>){
        mDATAset=phoneList
        notifyDataSetChanged()
    }

    inner class PhonesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_products_list,parent,false)
    return PhonesHolder(view)
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mDATAset.size
    }
}