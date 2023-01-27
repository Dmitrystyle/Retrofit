package com.example.retrofit


import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{userName}/repos")

    suspend fun getUsers(): List<User>



}