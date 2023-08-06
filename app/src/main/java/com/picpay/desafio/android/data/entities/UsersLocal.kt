package com.picpay.desafio.android.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.picpay.desafio.android.utils.Constants

@Entity(tableName = Constants.DataBase.TABLE_NAME)
data class UsersLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name="username")
    val username:String,
    @ColumnInfo(name="img")
    val img:String
)
