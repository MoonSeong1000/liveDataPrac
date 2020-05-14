package com.example.livedataprac.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//저장할 Entity를 만들고 room table에 매핑 시킴
@Entity(tableName = "inputMsg")
data class InputMsg(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var msgId:Int=0,
    @ColumnInfo(name="msg") var msg : String =""
)