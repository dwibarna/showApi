package com.sobarna.testmidas

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    fun apiConfig(): ApiService {
        val url = "http://midas-be-task.herokuapp.com/"

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        return retrofitBuilder

    }

}