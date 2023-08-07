package com.picpay.desafio.android.presenter.repository

import com.picpay.desafio.android.data.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.service.ImpPicPayService
import com.picpay.desafio.android.data.service.PicPayService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(){

    fun getListUsers(listener: UserListener){

        val service = ImpPicPayService().createService(PicPayService::class.java)
        val callService = service.getUsers()

        callService.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    listener.onFailureResponse(t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.code() == 200){
                    response.body()?.let { listener.onSucessResponse(response = it) }
                }else{
                    listener.onFailureResponse(response.errorBody().toString())
                }

            }
        })
    }

}