package com.mindorks.retrofit.coroutines.ui.base.data.repository

import com.mindorks.retrofit.coroutines.ui.base.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}