package com.picpay.desafio.android.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val useCase: UserUseCase) : ViewModel() {

    private val _responseUsers = MutableLiveData<List<User>>()
    val responseUsers: LiveData<List<User>> = _responseUsers

    fun getResponseUser() {
        viewModelScope.launch {
            _responseUsers.value = useCase.getUsers()
        }
    }
}