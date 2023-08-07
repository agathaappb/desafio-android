package com.picpay.desafio.android.di

import android.content.Context
import com.picpay.desafio.android.data.database.UserDataBase
import com.picpay.desafio.android.data.service.ImpPicPayService
import com.picpay.desafio.android.data.service.PicPayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideUserRemote(): PicPayService {
        return ImpPicPayService().createService(PicPayService::class.java)
    }

    @Singleton
    @Provides
    fun providesCoroutineScope(): Dispatchers {
        return Dispatchers
    }

}