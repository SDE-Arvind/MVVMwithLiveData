package com.example.myapplication.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.entities.Person

@Database(entities = arrayOf(Person::class), version = 1,exportSchema = false)
abstract class MyRoomDataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object{

        @Volatile
        private var INSTANCE: MyRoomDataBase? = null

        fun getInstance(context: Context): MyRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyRoomDataBase::class.java,
                    "mydatabase1"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                instance
            }
        }

    }

}