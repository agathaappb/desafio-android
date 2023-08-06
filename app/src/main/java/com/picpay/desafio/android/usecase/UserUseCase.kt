package com.picpay.desafio.android.usecase

import com.picpay.desafio.android.ConverterObject
import com.picpay.desafio.android.data.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
){
    fun verifyCache(){
        val localData = localRepository.getAll()

        if (localData.isEmpty()){
            remoteRepository.getListUsers(object : UserListener{
                override fun onSucessResponse(response: List<User>) {
                    localRepository.insert(response)
                }

                override fun onFailureResponse(message: String) {

                }
            })
        }
    }

    fun userData():List<User>{
        return ConverterObject().dataLocalFormatterDataRemoteFormat(localRepository.getAll())
    }


}