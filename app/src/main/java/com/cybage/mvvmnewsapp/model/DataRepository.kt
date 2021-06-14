package com.cybage.mvvmnewsapp.model

import androidx.room.withTransaction
import com.cybage.mvvmnewsapp.api.DataApi
import com.cybage.mvvmnewsapp.util.networkBoundResource
import kotlinx.coroutines.flow.first
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
            api.getDataAnnually()
        },
        saveFetchResult = { data ->
            dataDatabase.withTransaction {
                dataDAO.deleteAllData()
                val item = dataDAO.getAllData().first()
                item.forEach {
                    val result = Records(it.volume_of_mobile_data,it.quarter,it._id)
                   dataDAO.insertData(result)
                }
            }
        }
    )
}