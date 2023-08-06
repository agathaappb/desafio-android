package com.picpay.desafio.android.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.picpay.desafio.android.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.domain.UsersRepository

class UserViewModel(): ViewModel() {
    private val usersRepository = UsersRepository()

    private val _responseUsers = MutableLiveData<List<User>>()
    val responseUsers: LiveData<List<User>> = _responseUsers

    fun getResponseUser(){
        usersRepository.getListUsers(object : UserListener{
            override fun onSucessResponse(response: List<User>) {
                _responseUsers.value = response
            }

            override fun onFailureResponse(message: String) {
                TODO("Not yet implemented")
            }

        })

    }
}