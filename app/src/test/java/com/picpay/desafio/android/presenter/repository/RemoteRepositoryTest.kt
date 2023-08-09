package com.picpay.desafio.android.presenter.repository

import com.nhaarman.mockitokotlin2.mock
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Response

class RemoteRepositoryTest() {

    val dataFormatUser = listOf<User>(
        User("https://randomuser.me/api/portraits/men/1.jpg",
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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getListUsers() = runTest {
        val mockService = mock<PicPayService>()
        val mockDispatcher = mock<Dispatchers>()
        val repository = RemoteRepository(mockService, mockDispatcher)

        Mockito.`when`(mockService.getUser()).thenReturn(Response.success(dataFormatUser))

        val data = repository.getListUser()

        assertEquals(dataFormatUser, data)
    }
}