package com.example.retrofit


class ApiHelper(private val apiService: ApiService) {

    suspend fun getRepo(user:String) = apiService.getRepo(user)
}