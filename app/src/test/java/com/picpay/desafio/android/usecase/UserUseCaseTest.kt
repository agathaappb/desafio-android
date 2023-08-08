package com.picpay.desafio.android.usecase


import com.nhaarman.mockitokotlin2.mock
import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert

import org.junit.Test
import org.mockito.Mockito

class UserUseCaseTest {

    val dataFormatUser = listOf<User>(
        User("https://randomuser.me/api/portraits/men/1.jpg","Sandrine Spinka", 1,"Tod86"),
        User("https://randomuser.me/api/portraits/men/2.jpg","Carli Carroll", 2,"Constantin_Sawayn"),
        User("https://randomuser.me/api/portraits/men/3.jpg","Annabelle Reilly", 3,"Lawrence_Nader62"),
        User("https://randomuser.me/api/portraits/men/4.jpg","Mrs. Hilton Welch", 4,"Tatyana_Ullrich")
    )
    val dataFormatUserLocal= listOf<UsersLocal>(
        UsersLocal(1,"Sandrine Spinka", "Tod86","https://randomuser.me/api/portraits/men/1.jpg"),
        UsersLocal(2,"Carli Carroll", "Constantin_Sawayn","https://randomuser.me/api/portraits/men/2.jpg"),
        UsersLocal(3,"Annabelle Reilly", "Lawrence_Nader62","https://randomuser.me/api/portraits/men/3.jpg"),
        UsersLocal(4,"Mrs. Hilton Welch", "Tatyana_Ullrich","https://randomuser.me/api/portraits/men/4.jpg"),)

    @Test
    fun getUsersWhenCacheIsEmpty()=runBlockingTest{

    }

    @Test
    fun getUsersWhenCacheIsNotEmpty(){
        val cache = dataFormatUser

    }

    @Test
    fun localDataUser()= runBlockingTest{
        Assert.assertEquals(4, 2+2)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun remoteDataUser()= runBlockingTest{
        val mockLocalRepository = mock<LocalRepository>()
        val mockRemoteRepository = mock<RemoteRepository>()
        val mockDispatcher = mock<Dispatchers>()
        val useCase = UserUseCase(mockLocalRepository, mockRemoteRepository,mockDispatcher)

        Mockito.`when`(mockLocalRepository.getAll()).thenReturn(dataFormatUserLocal)

        val data = useCase.localDataUser()

        Assert.assertEquals(dataFormatUser, data)
    }


}