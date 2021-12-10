package com.example.myapplication.model.database

import androidx.annotation.WorkerThread
import androidx.room.Query
import com.example.myapplication.model.entities.Person
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao) {

    @WorkerThread
    suspend fun insertPerson(person: Person){
        personDao.insert(person)
    }

    val allPersonList: Flow<List<Person>> = personDao.getUsers()
}