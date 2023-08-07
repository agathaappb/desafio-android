package com.picpay.desafio.android.usecase

import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.UserListener
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
){
    fun verifyCache():List<User>{

       remoteRepository.getListUsers(object : UserListener{
                override fun onSucessResponse(response: List<User>) {
                    localRepository.insert(response)
                }

                override fun onFailureResponse(message: String) {

                }
       })
        return ConverterObject().dataLocalFormatterDataRemoteFormat(localRepository.getAll())


    }

    fun userData():List<User>{
        return ConverterObject().dataLocalFormatterDataRemoteFormat(localRepository.getAll())
    }


}