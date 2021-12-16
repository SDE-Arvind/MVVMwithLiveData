package com.example.myapplication.model.database

import androidx.room.*
import com.example.myapplication.model.entities.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert()
    suspend fun insert(person: Person)

    @Query("Select * from Users")
    fun getUsers() : Flow<List<Person>>
}