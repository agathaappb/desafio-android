package com.picpay.desafio.android.presenter.repository

import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.picpay.desafio.android.data.ConverterObject
import com.picpay.desafio.android.data.dao.UserDao
import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.domain.repository.LocalRepository
import org.junit.Assert.*

import org.junit.Test
import org.mockito.Mockito

class LocalRepositoryTest {

    @Test
    fun insert() {
        val dao = mock<UserDao>()
        val localRepository = LocalRepository(dao)
        val data = listOf<User>(
            User(
                "https://randomuser.me/api/portraits/men/1.jpg",
                "Sandrine Spinka",
                1,
                "Tod86"),
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

        val newData = ConverterObject().dataRemoteFormatterDataBaseFormat(data)

        doNothing().`when`(dao).insert(newData)

        localRepository.insert(data)

        verify(dao, com.nhaarman.mockitokotlin2.times(1)).insert(newData)
    }

    @Test
    fun getAll() {
        val dao = mock<UserDao>()
        val localRepository = LocalRepository(dao)
        val data = listOf<UsersLocal>(
            UsersLocal(
                1,
                "Sandrine Spinka",
                "Tod86",
                "https://randomuser.me/api/portraits/men/1.jpg"
            ),
            UsersLocal(
                2,
                "Carli Carroll",
                "Tod86",
                "https://randomuser.me/api/portraits/men/2.jpg"
            ),
            UsersLocal(
                3,
                "Annabelle Reilly",
                "Tod86",
                "https://randomuser.me/api/portraits/men/3.jpg"
            ),
            UsersLocal(
                4,
                "Mrs. Hilton Welch",
                "Tod86",
                "https://randomuser.me/api/portraits/men/4.jpg"
            ),
        )

        Mockito.`when`(dao.getAll()).thenReturn(data)

        val newData = localRepository.getAll()

        assertEquals(data, newData)
    }
}