package com.example.trialnewsapplication.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.fragment.Home_Fragment
import com.example.trialnewsapplication.view.ArticlesItem
import io.supercharge.shimmerlayout.ShimmerLayout

class My_Adpter(val context: Context?, val list: List<ArticlesItem?>) :
    RecyclerView.Adapter<My_Adpter.ViewData>() {
    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img_news = itemView.findViewById<CardView>(R.id.img_news)
        var img_newscv = itemView.findViewById<ImageView>(R.id.img_newscv)
        var txt_title = itemView.findViewById<TextView>(R.id.txt_title)
        var txt_title_name = itemView.findViewById<TextView>(R.id.txt_title_name)
        var txt_subtitle = itemView.findViewById<TextView>(R.id.txt_subtitle)
//        val layout: ShimmerLayout = itemView.findViewById(R.id.simmerEffact)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var img = list[position]?.urlToImage

        holder.txt_subtitle.text = list[position]?.description
        Glide.with(context!!).load(img).centerCrop().into(holder.img_newscv)
        holder.txt_title.text = list[position]?.title
        holder.txt_title_name.text = list[position]?.source!!.name

//        holder.layout.stopShimmerAnimation()

    }

    override fun getItemCount(): Int {
        return list.size

    }

}