package com.picpay.desafio.android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.data.entities.UsersLocal

@Dao
interface UserDao {

    @Query("SELECT * FROM users_local")
    fun getAll(): List<UsersLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<UsersLocal>)

}