package com.example.livedataprac.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.livedataprac.model.InputMsg

@Dao
interface InputMsgDao {
    @Query("SELECT * FROM inputMsg")
    fun getAll(): LiveData<List<InputMsg>>

    @Insert
    fun insertMsg(inputMsg: InputMsg)
}