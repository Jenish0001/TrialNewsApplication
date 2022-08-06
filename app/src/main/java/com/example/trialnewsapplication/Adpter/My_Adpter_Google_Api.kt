package com.example.trialnewsapplication.Adpter

import android.media.tv.TvView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trialnewsapplication.MainActivity
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.view.ArticlesItem

class My_Adpter_Google_Api(val mainActivity: MainActivity, val list: List<ArticlesItem?>) :
    RecyclerView.Adapter<My_Adpter_Google_Api.viewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.item_google, parent, false)

        return My_Adpter_Google_Api.viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {

        var img = list[position]?.urlToImage
//        holder.txt_subtitle.text = list[position]?.description
//        Glide.with(context!!).load(img).centerCrop().into(holder.img_newscv)
//        holder.txt_title.text = list[position]?.title
//        holder.txt_title_name.text = list[position]?.source!!.name

        holder.text_Title.text = list[position]?.title
        Glide.with(mainActivity!!).load(img).centerCrop().into(holder.image_view)
        holder.text_sub.text = list[position]?.description
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var text_sub = itemView.findViewById<TextView>(R.id.text_sub)
        var text_Title = itemView.findViewById<TextView>(R.id.text_Title)
        var image_view = itemView.findViewById<ImageView>(R.id.image_view)


    }
}