package com.example.retrofit


class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
}