package com.example.trialnewsapplication.tabFragmant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.util.StsticFile.Companion.country
import com.example.trialnewsapplication.Adpter.My_Adpter
import com.example.trialnewsapplication.activity.MainActivity
import com.example.trialnewsapplication.R
import com.example.trialnewsapplication.view.ApiClient
import com.example.trialnewsapplication.view.ApiInterface
import com.example.trialnewsapplication.view.ArticlesItem
import com.example.trialnewsapplication.view.Newsmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Science_Fragment(val homeFragment: MainActivity) : Fragment() {

    lateinit var RvView: RecyclerView
    var list = listOf<ArticlesItem?>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_business_, container, false)

        RvView = view!!.findViewById<RecyclerView>(R.id.RvView)

        getNews(country, "science")
        rvSetUp()
        return view

    }

    fun getNews(country: String, category: String) {
        var apiInterface = ApiClient.getretrofit().create(ApiInterface::class.java)
        apiInterface.getNews(country, category, "89f86dad7f9a44ceb88bb6409b26a770")
            .enqueue(object : Callback<Newsmodel> {

                override fun onResponse(call: Call<Newsmodel>, response: Response<Newsmodel>) {
                    var newsModel = response.body()
                    list = newsModel?.articles!!

//                    Log.e("TAG", "onResponse: ${response.body()}")
                    rvSetUp()
                }

                override fun onFailure(call: Call<Newsmodel>, t: Throwable) {
//                    Log.e("TAG", "onFailure: ${t.message}")
                }

            })

    }

    fun rvSetUp() {
        var myAdpter = My_Adpter(homeFragment, list)
        var lm = LinearLayoutManager(homeFragment)
        RvView.adapter = myAdpter
        RvView.layoutManager = lm
    }
//override fun onStart() {
//
//    Handler().postDelayed(Runnable {
//        rvSetUp()
//    }, 5000)
//    super.onStart()
//}

//    override fun onResume() {
//        Handler().postDelayed(Runnable {
//            rvSetUp()
//        }, 5000)
//        super.onResume()
//    }

}