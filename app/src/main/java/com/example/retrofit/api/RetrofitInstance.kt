package com.example.retrofit.api

import androidx.navigation.NavArgsLazy
import com.example.retrofit.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }



}