package com.cybage.mvvmnewsapp.data

import androidx.room.withTransaction
import com.cybage.mvvmnewsapp.api.DataApi
import com.cybage.mvvmnewsapp.api.Result
import com.cybage.mvvmnewsapp.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

open class DataRepository @Inject constructor(
    private val api : DataApi,
    private val dataDatabase: DataDatabase
) {
    private val dataDAO = dataDatabase.dataDAO()

    fun getData() = networkBoundResource(

        query = {
            dataDAO.getAllData()
        },
        fetch = {
            delay(2000)
            api.getDataAnnually()
        },
        saveFetchResult = { data ->
            dataDatabase.withTransaction {
                dataDAO.deleteAllData()
                data.forEach {
                    val result = Result(it.volume_of_mobile_data,it.quarter,it._id)
                    dataDAO.insertData(result)
                }
            }
        }
    )
}