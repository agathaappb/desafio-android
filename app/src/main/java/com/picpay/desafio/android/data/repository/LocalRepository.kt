package com.picpay.desafio.android.data.repository

import android.content.Context
import com.picpay.desafio.android.data.database.UserDataBase
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User

class LocalRepository(context: Context) {

    private val userDataBase = UserDataBase.getDataBase(context).userDao()

    fun insert(users: List<User>){
        for (user in users){
            userDataBase.insert(UsersLocal(user.id,user.name, user.username,user.img))
        }
        userDataBase.getAll()
    }


    fun getAll():List<UsersLocal> = userDataBase.getAll()


}