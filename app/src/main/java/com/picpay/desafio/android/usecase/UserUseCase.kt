package com.picpay.desafio.android.usecase

import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class UserUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    private val defaultDispatcher: Dispatchers
){

    suspend fun getUsers():List<User>{
        return withContext(defaultDispatcher.Default) {
            val cache = localDataUser()

            if (cache.isEmpty()){
                return@withContext remoteDataUser()
            }else{
                return@withContext cache
            }
        }
    }

    suspend fun remoteDataUser():List<User>{
        return withContext(defaultDispatcher.Default) {
           var dataUser = remoteRepository.getListUser()
            localRepository.insert(dataUser)
            return@withContext dataUser
        }
    }

    fun localDataUser():List<User>{
        return ConverterObject().dataLocalFormatterDataRemoteFormat(localRepository.getAll())
    }

}