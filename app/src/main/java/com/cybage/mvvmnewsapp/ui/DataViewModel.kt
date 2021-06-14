package com.cybage.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.cybage.mvvmnewsapp.model.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(repository: DataRepository)
    : ViewModel() {

    val data = repository.getData().asLiveData()

}