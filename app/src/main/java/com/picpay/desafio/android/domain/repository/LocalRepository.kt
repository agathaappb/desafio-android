package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val userDataBase: UserDao
) {

    fun insert(users: List<User>) {
        userDataBase.insert(ConverterObject().dataRemoteFormatterDataBaseFormat(users))
    }

    fun getAll(): List<UsersLocal> = userDataBase.getAll()
}