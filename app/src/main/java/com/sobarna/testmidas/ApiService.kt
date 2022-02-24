package com.sobarna.testmidas

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/midas/config/v1/foodDelivery/dataContent?version=1")
    fun getApi(): Call<Response>
}