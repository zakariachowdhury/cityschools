package com.zakariachowdhury.cityschools

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideCitySchoolsApi(): CitySchoolsApi {
        return Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(CitySchoolsApi::class.java)
    }
}