package com.cybage.mvvmnewsapp.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cybage.mvvmnewsapp.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(repository: DataRepository)
    : ViewModel() {

    val data = repository.getData().asLiveData()

}