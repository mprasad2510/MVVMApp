package com.cybage.mvvmnewsapp.api

import com.google.gson.annotations.SerializedName

data class DataResponse (

	@SerializedName("help") val help : String,
	@SerializedName("success") val success : Boolean,
	@SerializedName("result") val result : Result
)