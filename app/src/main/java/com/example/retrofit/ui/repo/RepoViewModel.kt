package com.example.retrofit.ui.repo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofit.Repository
import com.example.retrofit.Resource
import kotlinx.coroutines.Dispatchers


class RepoViewModel(private val repository: Repository) : ViewModel() {

    fun getRepo(user: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getRepo(user)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}