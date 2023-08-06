package com.picpay.desafio.android.presenter.repository

import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalRepository @Inject constructor(
    private val userDataBase: UserDao
) {

    fun insert(users: List<User>) {
        for (user in users) {
            userDataBase.insert(UsersLocal(user.id, user.name, user.username, user.img))
        }
    }


    fun getAll(): List<UsersLocal> = userDataBase.getAll()


}