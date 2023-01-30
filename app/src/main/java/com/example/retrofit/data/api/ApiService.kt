package com.example.retrofit


import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{userName}/repos")

    suspend fun getRepo(@Path("userName") user: String
    ): List<Repo>



}