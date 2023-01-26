package com.mindorks.retrofit.coroutines.ui.base.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
}