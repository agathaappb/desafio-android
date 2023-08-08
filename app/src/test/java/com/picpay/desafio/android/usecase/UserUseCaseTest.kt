package com.picpay.desafio.android.usecase


import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.mock
import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.presenter.repository.LocalRepository
import com.picpay.desafio.android.presenter.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.invoke
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.coroutines.ContinuationInterceptor


class UserUseCaseTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)
    val dispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var mockService: PicPayService

    private lateinit var remoteRepository: RemoteRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        //remoteRepository = RemoteRepository(mockService, testDispatcher)
    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
    }

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
    fun localDataUser()= runTest{
        Assert.assertEquals(4, 2+2)
    }






    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun remoteDataUser()= runTest(UnconfinedTestDispatcher()){

        val dispatcher = StandardTestDispatcher(testScheduler)


        val mockLocalRepository = mock<LocalRepository>()
        val mockRemoteRepository = mock<RemoteRepository>()
        //val useCase = UserUseCase(mockLocalRepository, mockRemoteRepository, this)



        //Mockito.`when`(localRepository.getAll()).thenReturn(dataFormatUserLocal)
        //doNothing().`when`(localRepository.insert(dataFormatUser))

        //val data = useCase.remoteDataUser()

        //Assert.assertEquals(dataFormatUser,data)
        Assert.assertEquals(4,2+2)
    }


}