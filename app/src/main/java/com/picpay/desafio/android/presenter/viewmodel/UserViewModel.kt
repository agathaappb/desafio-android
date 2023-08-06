package com.picpay.desafio.android.presenter.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.picpay.desafio.android.data.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import com.picpay.desafio.android.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(val useCase: UserUseCase): ViewModel() {


    private val _responseUsers = MutableLiveData<List<User>>()
    val responseUsers: LiveData<List<User>> = _responseUsers

    fun getResponseUser(){

        useCase.verifyCache()

        _responseUsers.value = useCase.userData()

    }
}