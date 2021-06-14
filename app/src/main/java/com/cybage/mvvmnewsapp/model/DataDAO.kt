package com.cybage.mvvmnewsapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDAO {

    @Query("Select * FROM annualData")
    fun getAllData() : Flow<List<Records>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(annually: Records)

    @Query("delete FROM annualData")
    suspend fun deleteAllData()

}