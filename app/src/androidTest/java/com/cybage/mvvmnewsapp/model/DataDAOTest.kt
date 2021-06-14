package com.cybage.mvvmnewsapp.model

import kotlinx.coroutines.test.runBlockingTest
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

class DataDAOTest {

    @Inject
    @Named("annualData")
    lateinit var database: DataDatabase
    private lateinit var dao: DataDAO

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.dataDAO()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {

        val item = DataAnnually(1.234)
        dao.insertData(item)

        val allitem = dao.getAllData()

        assertThat(allitem).contains(item)
    }

    @Test
    fun deleteShoppingItem() = runBlockingTest {
        val item = DataAnnually(1.234)
        dao.insertData(item)
        dao.deleteAllData(item)

        val allShoppingItems = dao.getAllData()

        assertThat(allShoppingItems).doesNotContain(item)
    }

}