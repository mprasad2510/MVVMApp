package com.cybage.mvvmnewsapp.api

import com.cybage.mvvmnewsapp.data.Records
import com.google.gson.annotations.SerializedName

data class RecordResponse (@SerializedName("Records") var records: List<RecordDto>)