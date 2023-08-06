package com.picpay.desafio.android.presenter.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.repository.LocalRepository
import com.picpay.desafio.android.data.repository.RemoteRepository

class UserViewModel(): ViewModel() {



    private val remoteRepository = RemoteRepository()


    private val _responseUsers = MutableLiveData<List<User>>()
    val responseUsers: LiveData<List<User>> = _responseUsers

    fun getResponseUser(context: Context){

        remoteRepository.getListUsers(object : UserListener{
            val localRepository = LocalRepository(context)
            override fun onSucessResponse(response: List<User>) {
                _responseUsers.value = response
                localRepository.insert(response)
            }

            override fun onFailureResponse(message: String) {
                TODO("Not yet implemented")
            }

        })
    }
}