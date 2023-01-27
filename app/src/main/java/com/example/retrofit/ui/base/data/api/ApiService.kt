package com.example.retrofit


import retrofit2.http.GET

interface ApiService {

    @GET("users/Dmitrystyle/repos")
    suspend fun getUsers(): List<User>

}