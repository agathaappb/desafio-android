package com.picpay.desafio.android.usecase

import com.nhaarman.mockitokotlin2.mock
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class UserUseCaseTest {

    val mockRemoteRepository = mock<RemoteRepository>()
    val mockLocalRepository = mock<LocalRepository>()
    val mockDispatcher = mock<Dispatchers>()
    val userUseCase = UserUseCase(mockLocalRepository, mockRemoteRepository, mockDispatcher)

    val dataFormatUser = listOf<User>(
        User(
            "https://randomuser.me/api/portraits/men/1.jpg",
            "Sandrine Spinka",
            1,
            "Tod86"
        ),
        User(
            "https://randomuser.me/api/portraits/men/2.jpg",
            "Carli Carroll",
            2,
            "Constantin_Sawayn"
        ),
        User(
            "https://randomuser.me/api/portraits/men/3.jpg",
            "Annabelle Reilly",
            3,
            "Lawrence_Nader62"
        ),
        User(
            "https://randomuser.me/api/portraits/men/4.jpg",
            "Mrs. Hilton Welch",
            4,
            "Tatyana_Ullrich"
        )
    )
    val dataFormatUserLocal = listOf<UsersLocal>(
        UsersLocal(
            1,
            "Sandrine Spinka",
            "Tod86",
            "https://randomuser.me/api/portraits/men/1.jpg"
        ),
        UsersLocal(
            2,
            "Carli Carroll",
            "Constantin_Sawayn",
            "https://randomuser.me/api/portraits/men/2.jpg"
        ),
        UsersLocal(
            3,
            "Annabelle Reilly",
            "Lawrence_Nader62",
            "https://randomuser.me/api/portraits/men/3.jpg"
        ),
        UsersLocal(
            4,
            "Mrs. Hilton Welch",
            "Tatyana_Ullrich",
            "https://randomuser.me/api/portraits/men/4.jpg"
        ),
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getUsersWhenCacheIsEmpty() = runTest {

        Mockito.`when`(mockLocalRepository.getAll()).thenReturn(dataFormatUserLocal)

        val data = userUseCase.getUsers()

        Assert.assertEquals(dataFormatUser, data)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getUsersWhenCacheIsNotEmpty() = runTest {

        Mockito.`when`(mockRemoteRepository.getListUser()).thenReturn(dataFormatUser)

        val data = userUseCase.getUsers()

        Assert.assertEquals(dataFormatUser, data)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun localDataUser() = runTest {

        Mockito.`when`(mockLocalRepository.getAll()).thenReturn(dataFormatUserLocal)

        val data = userUseCase.localDataUser()

        Assert.assertEquals(dataFormatUser, data)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun remoteDataUser() = runTest {

        Mockito.`when`(mockRemoteRepository.getListUser()).thenReturn(dataFormatUser)

        val data = userUseCase.remoteDataUser()

        Assert.assertEquals(dataFormatUser, data)
    }
}