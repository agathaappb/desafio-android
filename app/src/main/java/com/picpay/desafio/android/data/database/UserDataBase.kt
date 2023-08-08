package com.picpay.desafio.android.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.utils.Constants

@Database(entities = [UsersLocal::class], version = Constants.DataBase.VERSION)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private lateinit var INSTANCE: UserDataBase

        fun getDataBase(context: Context): UserDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(UserDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        UserDataBase::class.java,
                        Constants.DataBase.DATABASE_NAME
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}