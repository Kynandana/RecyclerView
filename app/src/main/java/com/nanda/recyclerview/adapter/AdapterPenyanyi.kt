package com.nanda.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanda.recyclerview.databinding.ListItemPenyanyiBinding
import com.nanda.recyclerview.model.Penyanyi

class AdapterPenyanyi(private val context : Context,
                        private var data : List<Penyanyi>?,
                        private val itemClick : OnClickListener)
    : RecyclerView.Adapter<AdapterPenyanyi.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ListItemPenyanyiBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener { itemClick.detailData(item) }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class ViewHolder( val binding : ListItemPenyanyiBinding): RecyclerView.ViewHolder(binding.root)    {
        var foto = binding.image
        var nama = binding.txtnama
    }

    interface OnClickListener {
        fun detailData(item : Penyanyi?)
    }

}