package com.example.myapplication

import android.app.Application
import com.example.myapplication.model.database.MyRoomDataBase
import com.example.myapplication.model.database.PersonRepository

class MyApplication : Application() {
    private val database by lazy { MyRoomDataBase.getInstance(this@MyApplication) }

    val reposatory by lazy { PersonRepository(database.personDao()) }
}