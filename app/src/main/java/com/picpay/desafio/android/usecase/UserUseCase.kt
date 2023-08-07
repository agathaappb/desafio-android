package com.picpay.desafio.android.usecase

import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import com.picpay.desafio.android.presenter.viewmodel.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    private val defaultDispatcher: Dispatchers
){
    fun verifyCache(){


    }


    suspend fun remoteDataUser():List<User>{
        return withContext(defaultDispatcher.Default) {
           remoteRepository.getListUserCorroutine()
        }
    }

    fun userData():List<User>{
        return ConverterObject().dataLocalFormatterDataRemoteFormat(localRepository.getAll())
    }


}