package com.lefg095.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lefg095.myapplication.databinding.ItemBinding

class MyAdapter(
    var arrayList: ArrayList<Data>,
    var context: Context
    ): RecyclerView.Adapter<MyAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return DataViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dato = arrayList[position]
        holder.bind(dato)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class DataViewHolder(view: View): RecyclerView.ViewHolder(view)  {
        private val binding = ItemBinding.bind(view)
        fun bind(dato: Data){
            binding.tvDesc.text = dato.description
            binding.tvId.text = dato.id.toString()
            binding.tvName.text = dato.name
        }

    }
}