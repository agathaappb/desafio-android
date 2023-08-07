package com.picpay.desafio.android.presenter.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.presenter.adapter.UserListAdapter
import com.picpay.desafio.android.presenter.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: UserListAdapter
    private lateinit var userViewModel: UserViewModel

    override fun onResume() {
        super.onResume()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)

        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        progressBar.visibility = View.VISIBLE

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.getResponseUser()

        userViewModel.responseUsers.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                progressBar.visibility = View.GONE
                adapter.users = it
            }
        })
    }
}
