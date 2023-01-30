package com.example.retrofit

class Repository(private val apiHelper: ApiHelper) {

    suspend fun getRepo(user: String) = apiHelper.getRepo(user)


}