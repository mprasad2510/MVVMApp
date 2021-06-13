package com.cybage.mvvmnewsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cybage.mvvmnewsapp.api.Result

@Database(entities = [Result::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDAO() : DataDAO
}