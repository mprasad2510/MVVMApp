package com.cybage.mvvmnewsapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cybage.mvvmnewsapp.api.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDAO {

    @Query("Select * FROM annualData")
    fun getAllData() : Flow<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(annually: Result)

    @Query("delete FROM annualData")
    suspend fun deleteAllData()

}