package com.picpay.desafio.android.data

import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User

class ConverterObject {

    fun dataLocalFormatterDataRemoteFormat(data: List<UsersLocal>):List<User>{
        var newData = mutableListOf<User>()
        for (User in data){
            newData.add(User(User.img,User.name,User.id,User.username))
        }
        return newData
    }

    fun dataRemoteFormatterDataBaseFormat(data: List<User>):List<UsersLocal>{
        var newData = mutableListOf<UsersLocal>()
        for (UsersLocal in data){
            newData.add(UsersLocal(UsersLocal.id,UsersLocal.name,UsersLocal.username,UsersLocal.img))
        }
        return newData
    }

}