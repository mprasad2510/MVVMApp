package com.cybage.mvvmnewsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "annualData")
data class DataAnnually( @PrimaryKey @SerializedName("volume_of_mobile_data") val volume_of_mobile_data : Double
)