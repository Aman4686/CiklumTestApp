package com.example.ciklumtestapp.features.imageList

import TumbltResponsePOJO
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ciklumtestapp.R
import com.example.ciklumtestapp.databinding.ItemTumblrBinding

class ImageRecyclerAdapter constructor(val onClickListener: OnImageClickListener): RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder>() , View.OnClickListener{


    var tumblrResponseList = emptyList<TumbltResponsePOJO.Response>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tumblr, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val currentItem = tumblrResponseList[position]
            holder.binding.root.tag = currentItem
            loadImage(holder , currentItem)
            holder.binding.root.setOnClickListener(this@ImageRecyclerAdapter)
    }


    fun getImageUrlByResponse(currentItem : TumbltResponsePOJO.Response) : String =
        if(currentItem.photos != null)
            currentItem.photos[0].original_size.url
        else
            if (currentItem.trail.isEmpty()) ""
            else currentItem.trail[0].blog.theme.header_image



    private fun loadImage(holder: ViewHolder, currentItem : TumbltResponsePOJO.Response) {

        var imageUrl = getImageUrlByResponse(currentItem)

        Glide.with(holder.binding.root)
            .load(imageUrl)
            .apply(RequestOptions().override(500, 500))
            .error(R.mipmap.ic_launcher)
            .into(holder.binding.ivTumblr)
    }

    override fun onClick(v: View) {
        val currentItem = v.tag as TumbltResponsePOJO.Response
        var imageUrl = getImageUrlByResponse(currentItem)
        onClickListener.onClick(imageUrl)
    }

    override fun getItemCount(): Int {
        return tumblrResponseList.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: ItemTumblrBinding

        init {
            binding = ItemTumblrBinding.bind(itemView)
        }
    }


}