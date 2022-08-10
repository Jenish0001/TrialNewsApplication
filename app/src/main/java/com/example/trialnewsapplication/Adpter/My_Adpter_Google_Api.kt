package com.example.trialnewsapplication.Adpter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trialnewsapplication.activity.MainActivity
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.activity.Show_Activity
import com.example.trialnewsapplication.fragment.Home_Fragment
import com.example.trialnewsapplication.view.ArticlesItem

class My_Adpter_Google_Api(val my_activity: MainActivity, val list: List<ArticlesItem?>) :
    RecyclerView.Adapter<My_Adpter_Google_Api.viewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(my_activity).inflate(R.layout.item_google, parent, false)

        return My_Adpter_Google_Api.viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {

        var img = list[position]?.urlToImage
//        holder.txt_subtitle.text = list[position]?.description
//        Glide.with(context!!).load(img).centerCrop().into(holder.img_newscv)
//        holder.txt_title.text = list[position]?.title
//        holder.txt_title_name.text = list[position]?.source!!.name

        holder.text_Title.text = list[position]?.title
        Glide.with(my_activity!!).load(img).centerCrop().into(holder.image_view)
        holder.text_sub.text = list[position]?.description

        holder.rv1_view.setOnClickListener {

            Toast.makeText(my_activity, "${list[position]?.title}", Toast.LENGTH_SHORT).show()

            var title=list[position]?.title
            var description=list[position]?.description
            var name=list[position]?.source?.name
            var img1=list[position]?.urlToImage
            var author=list[position]?.author
           var contect  =list[position]?.content

            var i = Intent(my_activity,Show_Activity::class.java)
            i.putExtra("title",title)
            i.putExtra("des", description)
            i.putExtra("name", name)
            i.putExtra("img",img1)
            i.putExtra("author",author)
            i.putExtra("contect",contect)


                my_activity.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var text_sub = itemView.findViewById<TextView>(R.id.text_sub)
        var text_Title = itemView.findViewById<TextView>(R.id.text_Title)
        var image_view = itemView.findViewById<ImageView>(R.id.image_view)
        var rv1_view = itemView.findViewById<RelativeLayout>(R.id.rv1_view)


    }
}