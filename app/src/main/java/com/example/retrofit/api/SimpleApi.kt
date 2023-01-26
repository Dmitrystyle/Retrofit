package com.example.retrofit.api

import com.example.retrofit.model.Post
import retrofit2.http.GET

interface SimpleApi {

        @GET("users/Dmitrystyle/repos")
        suspend fun getPost(): Post

    }
