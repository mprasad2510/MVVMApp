package com.cybage.mvvmnewsapp.api

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cybage.mvvmnewsapp.data.Records

@Entity(tableName = "annualData")
data class Result (

	@ColumnInfo(name = "volume_of_mobile_data") var volume_of_mobile_data : Double,
	@ColumnInfo(name = "quarter") var quarter : String,
	@PrimaryKey(autoGenerate = true) @ColumnInfo (name = "_id" )var _id : Int
	)

