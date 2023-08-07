package com.picpay.desafio.android.usecase


import com.nhaarman.mockitokotlin2.mock
import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import org.junit.Assert

import org.junit.Test
import org.mockito.Mockito

class UserUseCaseTest {


    @Test
    fun verifyCache() {
    }

    @Test
    fun userData() {
        val mockDao = mock<UserDao>()
        val mockLocalRepository = LocalRepository(mockDao)
        val mockRemoteRepository = RemoteRepository()
        val mockUserUseCase = UserUseCase(mockLocalRepository,mockRemoteRepository)

        val data = listOf<User>(
            User("https://randomuser.me/api/portraits/men/1.jpg","Sandrine Spinka", 1,"Tod86"),
            User("https://randomuser.me/api/portraits/men/2.jpg","Carli Carroll", 2,"Constantin_Sawayn"),
            User("https://randomuser.me/api/portraits/men/3.jpg","Annabelle Reilly", 3,"Lawrence_Nader62"),
            User("https://randomuser.me/api/portraits/men/4.jpg","Mrs. Hilton Welch", 4,"Tatyana_Ullrich")
        )

        Mockito.`when`(mockLocalRepository.getAll()).thenReturn(ConverterObject().dataRemoteFormatterDataBaseFormat(data))

        val newData = mockUserUseCase.localDataUser()

        Assert.assertEquals(data, newData)
    }
}