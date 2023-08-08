package com.picpay.desafio.android.presenter.repository

import android.util.Log
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    val service: PicPayService,
    val dispatcher: Dispatchers
) {

    suspend fun getListUser(): List<User> {
        return withContext(dispatcher.IO) {
            val service = service.getUser()

            if (service.code() == Constants.Network.STATUS_CODE_200) {
                return@withContext service.body() ?: listOf<User>()
            } else {
                Log.e(Constants.Network.TAG_ERROR, service.message())
                return@withContext listOf<User>()
            }
        }
    }
}