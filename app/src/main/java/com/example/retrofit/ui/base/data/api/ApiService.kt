package com.mindorks.retrofit.coroutines.ui.base.data.api

import com.mindorks.retrofit.coroutines.ui.base.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users/Dmitrystyle/repos")
    suspend fun getUsers(): List<User>

}