package com.picpay.desafio.android.presenter.repository

import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.service.PicPayService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    val service: PicPayService,
    val dispatcher: Dispatchers
){

    suspend fun getListUser(): List<User>{
        return withContext(dispatcher.IO) {
            val callService = service.getUser()
            callService
        }
    }
}