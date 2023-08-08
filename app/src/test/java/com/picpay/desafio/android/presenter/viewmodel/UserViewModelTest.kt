package com.picpay.desafio.android.presenter.viewmodel

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.usecase.UserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class UserViewModelTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {

        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getResponseUsers() = runTest(UnconfinedTestDispatcher()) {
        val mockUserUseCase = mock<UserUseCase>()
        val userViewModel = UserViewModel(mockUserUseCase)

        Mockito.`when`(mockUserUseCase.getUsers()).thenReturn(dataFormatUser)

        userViewModel.getResponseUser()

        verify(mockUserUseCase, times(1)).getUsers()
    }
}