package com.picpay.desafio.android.data

import com.picpay.desafio.android.data.entities.UsersLocal
import com.picpay.desafio.android.data.model.User
import org.junit.Assert.*

import org.junit.Test


class ConverterObjectTest {

    val dataConvertInFormartUserLocal= listOf<UsersLocal>(
        UsersLocal(1,"Sandrine Spinka", "Tod86","https://randomuser.me/api/portraits/men/1.jpg"),
        UsersLocal(2,"Carli Carroll", "Constantin_Sawayn","https://randomuser.me/api/portraits/men/2.jpg"),
        UsersLocal(3,"Annabelle Reilly", "Lawrence_Nader62","https://randomuser.me/api/portraits/men/3.jpg"),
        UsersLocal(4,"Mrs. Hilton Welch", "Tatyana_Ullrich","https://randomuser.me/api/portraits/men/4.jpg"),)

    val dataConvertInFormatUser = listOf<User>(
        User("https://randomuser.me/api/portraits/men/1.jpg","Sandrine Spinka", 1,"Tod86"),
        User("https://randomuser.me/api/portraits/men/2.jpg","Carli Carroll", 2,"Constantin_Sawayn"),
        User("https://randomuser.me/api/portraits/men/3.jpg","Annabelle Reilly", 3,"Lawrence_Nader62"),
        User("https://randomuser.me/api/portraits/men/4.jpg","Mrs. Hilton Welch", 4,"Tatyana_Ullrich")
    )

    @Test
    fun dataLocalFormatterDataRemoteFormat() {
        val newdata = ConverterObject().dataLocalFormatterDataRemoteFormat(dataConvertInFormartUserLocal)

        assertEquals(newdata,dataConvertInFormatUser)
    }

    @Test
    fun dataRemoteFormatterDataBaseFormat() {
        val newData = ConverterObject().dataRemoteFormatterDataBaseFormat(dataConvertInFormatUser)

        assertEquals(newData,dataConvertInFormartUserLocal)
    }

    @Test
    fun dataLocalFormatterDataRemoteFormatWhenListForEmpty() {
        val data = listOf<UsersLocal>()

        val dataFormatEmpty = ConverterObject().dataLocalFormatterDataRemoteFormat(data)

        assert(dataFormatEmpty.isEmpty())
    }

    @Test
    fun dataRemoteFormatterDataBaseFormatWhenListForEmpty(){
        val data = listOf<User>()

        val dataFormatEmpty = ConverterObject().dataRemoteFormatterDataBaseFormat(data)

        assert(dataFormatEmpty.isEmpty())
    }
}