package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository =Repository()
        val viewModelFactory=MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response->
            /*Log.d("Response",response.userId.toString())
            Log.d("Response",response.id.toString())
            Log.d("Response",response.title)
            Log.d("Response",response.body)*/
            binding.tvTextMassage.text=response.name


            //https://api.github.com/users/USERNAME/repos

        })


    }
}