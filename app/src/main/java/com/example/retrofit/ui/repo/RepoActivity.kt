package com.example.retrofit.ui.repo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.ApiHelper
import com.example.retrofit.Repo
import com.example.retrofit.RepositoryAdapter
import com.example.retrofit.RetrofitBuilder
import com.example.retrofit.Status.*
import com.example.retrofit.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recyclerView

class RepoActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding

    private lateinit var viewModel: RepoViewModel
    private lateinit var adapter: RepositoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupUI()
        setupObservers()

    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            RepoViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(RepoViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RepositoryAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {

        binding.button3.setOnClickListener {
            val user = binding.editTextTextPersonName3.text.toString()
            viewModel.getRepo(user)


            viewModel.getRepo(user).observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        SUCCESS -> {
                            recyclerView.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                            resource.data?.let { users -> retrieveList(users) }
                        }
                        ERROR -> {
                            recyclerView.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                        LOADING -> {
                            progressBar.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }
                    }
                }
            })
        }
    }

    private fun retrieveList(users: List<Repo>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }
}
