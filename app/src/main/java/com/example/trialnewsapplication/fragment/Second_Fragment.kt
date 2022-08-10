package com.example.trialnewsapplication.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trialnewsapplication.Adpter.My_Adpter_Google_Api
import com.example.trialnewsapplication.activity.MainActivity
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Second_Fragment(val mainActivity: MainActivity) : Fragment() {

    lateinit var rv_view_second: RecyclerView
    var list1 = listOf<ArticlesItem?>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_second_, container, false)
        rv_view_second = view.findViewById<RecyclerView>(R.id.rv_view_second)


        google_getNews()

        return view

    }

    fun google_getNews() {
        var apiInterface = ApiClient.getretrofit().create(ApiInterface::class.java)
        apiInterface.googlegetretrofit("science", "9e41272f5ec1439c9a0692b57ca606ba")

            .enqueue(object : Callback<GoogleNews> {

                //            Callback<GoogleNewsApi ======
                override fun onResponse(call: Call<GoogleNews>, response: Response<GoogleNews>) {
                    var newsModel = response.body()
                    list1 = newsModel?.articles!!

                    Log.e("TAG", "onResponse: ${response.body()}")
                    rvSetUp()
                }

                override fun onFailure(call: Call<GoogleNews>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }

            })

    }

    fun rvSetUp() {

        var myAdpter1 = My_Adpter_Google_Api(mainActivity, list1)
        var lm = LinearLayoutManager(mainActivity)
        rv_view_second.adapter = myAdpter1
        rv_view_second.layoutManager = lm

    }

}