package com.example.trialnewsapplication.view

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {

        var BASE_URL = "https://newsapi.org/v2/"
        var Google_BASE_URL = "https://newsapi.org/v2/"

        fun getretrofit(): Retrofit {
            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
        fun googlegetretrofit(): Retrofit {
            var retrofit = Retrofit.Builder()
                .baseUrl(Google_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }


// newsapi
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9e41272f5ec1439c9a0692b57ca606ba
// betcoin api in google news
//https://newsapi.org/v2/everything?q=bitcoin&apiKey=9e41272f5ec1439c9a0692b57ca606ba


}