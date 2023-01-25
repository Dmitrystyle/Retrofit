package com.example.retrofit.repository

import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.model.Post
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}