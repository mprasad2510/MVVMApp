package com.cybage.mvvmnewsapp.api

import Records
import retrofit2.http.GET


interface DataApi {

    companion object {
        const val BASE_URL = "https://data.gov.sg/api/action"
    }

    @GET("/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f&limit=400")
    suspend fun getDataAnnually(): List<Records>

}