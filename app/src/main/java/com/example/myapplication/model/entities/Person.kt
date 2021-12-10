package com.example.myapplication.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Person (
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo val userName: String
){
    constructor(userName: String) :this(0,userName)
}