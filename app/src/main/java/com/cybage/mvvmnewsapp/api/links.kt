package com.cybage.mvvmnewsapp.api

import com.google.gson.annotations.SerializedName

data class links (

	@SerializedName("start") val start : String,
	@SerializedName("next") val next : String
)