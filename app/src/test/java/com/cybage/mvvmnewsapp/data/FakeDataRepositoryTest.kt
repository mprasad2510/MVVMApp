package com.cybage.mvvmnewsapp.data

import com.cybage.mvvmnewsapp.api.DataApi
import com.cybage.mvvmnewsapp.api.DataApiTest
import org.mockito.Mock

class FakeDataRepositoryTest: DataRepository(api = DataApiTest,
    dataDatabase = DataDatabase
) {
    @Mock


}