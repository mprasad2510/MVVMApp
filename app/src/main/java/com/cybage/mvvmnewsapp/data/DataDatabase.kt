package com.cybage.mvvmnewsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cybage.mvvmnewsapp.api.RecordDto

@Database(entities = [Records::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDAO() : DataDAO
}