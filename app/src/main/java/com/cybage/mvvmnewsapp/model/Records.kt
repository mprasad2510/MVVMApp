package com.cybage.mvvmnewsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "annualData")
data class Records (
	@SerializedName("volume_of_mobile_data") var volume_of_mobile_data : Double,
	@SerializedName("quarter") var quarter : String,
	@PrimaryKey @SerializedName("_id") var _id : Int
)