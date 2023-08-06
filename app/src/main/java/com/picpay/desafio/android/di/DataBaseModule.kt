package com.picpay.desafio.android.di

import android.content.Context
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.database.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideUserDataBase(@ApplicationContext context: Context): UserDataBase {
        return UserDataBase.getDataBase(context)
    }

    @Provides
    fun providerDAO(userDataBase: UserDataBase): UserDao{
        return userDataBase.userDao()
    }
}