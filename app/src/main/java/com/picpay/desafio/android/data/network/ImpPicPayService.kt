package com.picpay.desafio.android.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class ImpPicPayService {

    private val gson: Gson by lazy { GsonBuilder().create() }

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.Network.URL_BASE)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun<T> createervice(service: Class<T>):T{
        return retrofit.create(service)
    }
}