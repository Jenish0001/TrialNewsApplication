package com.example.trialnewsapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.databinding.ActivityShowBinding

class Show_Activity : AppCompatActivity() {

    lateinit var blindind: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_show)
        blindind = ActivityShowBinding.inflate(layoutInflater)
        setContentView(blindind.root)


        var title = intent.getStringExtra("title")
        var description = intent.getStringExtra("des")
        var name = intent.getStringExtra("name")
        var img = intent.getStringExtra("img")
        var author = intent.getStringExtra("author")
        var contect = intent.getStringExtra("contect")

        blindind.showNameTxt.text = name
        blindind.showTitelTxt.text=title
        blindind.showDesciTxt.text=description
        Glide.with(this).load(img).centerCrop().into(blindind.showImgView)
        blindind.showAuthorName.text=author
        blindind.showContectNo.text=contect

    }

}