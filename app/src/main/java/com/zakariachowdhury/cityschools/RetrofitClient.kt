package com.zakariachowdhury.cityschools

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val citySchoolsApi: CitySchoolsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(CitySchoolsApi::class.java)
    }
}