package com.example.trialnewsapplication.view

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    fun getNews(@Query("country") country: String, @Query("category") category: String, @Query("apikey") key: String)
            : Call<Newsmodel>


    @GET("everything")
    fun googlegetretrofit(@Query("q") q: String, @Query("apikey") key: String)
            : Call<GoogleNews>

}