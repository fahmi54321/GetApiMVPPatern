package com.example.getapimvppatern.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getapimvppatern.R
import com.example.getapimvppatern.model.ArticlesItem
import kotlinx.android.synthetic.main.item_get.view.*

class ApiAdapter(var data: List<ArticlesItem?>?):RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_get,parent,false)
        var holder = ApiViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return data?.size?:0
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.txtAuthor.text =data?.get(position)?.author
        holder.txtDescription.text = data?.get(position)?.description
        holder.txtTitle.text = data?.get(position)?.title
        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.urlToImage)
            .into(holder.gambar)
    }

    class ApiViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var txtAuthor = itemView.txtAuthor
        var txtDescription = itemView.txtDescription
        var txtTitle = itemView.txtTitle
        var gambar = itemView.gambar
    }
}