package com.picpay.desafio.android.data.service

import com.picpay.desafio.android.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    suspend fun getUser(): Response<List<User>>
}