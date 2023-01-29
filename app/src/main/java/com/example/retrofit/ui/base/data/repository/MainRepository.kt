package com.example.retrofit

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers(user: String) = apiHelper.getUsers(user)


}