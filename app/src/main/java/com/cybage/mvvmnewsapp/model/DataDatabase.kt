package com.cybage.mvvmnewsapp.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Records::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDAO() : DataDAO
}