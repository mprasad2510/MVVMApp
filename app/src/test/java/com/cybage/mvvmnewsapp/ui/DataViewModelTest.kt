package com.cybage.mvvmnewsapp.ui

import androidx.lifecycle.asLiveData
import com.cybage.mvvmnewsapp.model.DataRepository
import com.cybage.mvvmnewsapp.model.Records
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class DataViewModelTest : TestCase() {

    @Mock
    lateinit var repo: DataRepository

    lateinit var dataViewModelTest: DataViewModel

    @Before
    override fun setUp() {
     dataViewModelTest = DataViewModel(repo)
    }

    @Test
    fun getData() {
        val data = repo.getData().asLiveData()
        val newData = Records(12.345,"2018-Q4",2)
        assertEquals(newData,data)
    }
}