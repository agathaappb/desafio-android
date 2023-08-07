package com.picpay.desafio.android.presenter.repository

import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import javax.inject.Inject
import javax.inject.Singleton


class LocalRepository @Inject constructor(
    private val userDataBase: UserDao
) {

    fun insert(users: List<User>) {
        userDataBase.insert(ConverterObject().dataRemoteFormatterDataBaseFormat(users))
    }

    fun getAll(): List<UsersLocal> = userDataBase.getAll()

}