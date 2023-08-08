package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.service.ImpPicPayService
import com.picpay.desafio.android.data.service.PicPayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
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