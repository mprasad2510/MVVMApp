package com.cybage.mvvmnewsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataDAO::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDAO() : DataDAO
}