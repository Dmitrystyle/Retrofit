package com.example.retrofit


class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers(user:String) = apiService.getUsers(user)
}