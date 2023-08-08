package com.picpay.desafio.android.presenter.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
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
    private lateinit var messageError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setView()

        observerDataUser()
    }

    private fun setView() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)
        messageError = findViewById(R.id.message_error)

        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        progressBar.visibility = View.VISIBLE
    }

    private fun observerDataUser() {
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.getResponseUser()

        userViewModel.responseUsers.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                progressBar.visibility = View.GONE
                messageError.visibility = View.GONE
                adapter.users = it
            }else{
                progressBar.visibility = View.GONE
                messageError.visibility = View.VISIBLE

            }
        })
    }
}