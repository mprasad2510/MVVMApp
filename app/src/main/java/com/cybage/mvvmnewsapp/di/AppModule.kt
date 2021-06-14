package com.cybage.mvvmnewsapp.di

import android.app.Application
import androidx.room.Room
import com.cybage.mvvmnewsapp.api.DataApi
import com.cybage.mvvmnewsapp.model.DataDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() =
        Retrofit.Builder()
            .baseUrl(DataApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideDataApi(retrofit: Retrofit) : DataApi = retrofit.create(DataApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : DataDatabase =
        Room.databaseBuilder(application, DataDatabase::class.java, "data_database")
            .fallbackToDestructiveMigration()
            .build()



}