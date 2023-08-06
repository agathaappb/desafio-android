package com.picpay.desafio.android

import com.picpay.desafio.android.data.model.User

interface UserListener {
    fun onSucessResponse(response:List<User>)
    fun onFailureResponse(message:String)
}