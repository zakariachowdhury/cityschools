package com.zakariachowdhury.cityschools

import com.zakariachowdhury.cityschools.models.School
import retrofit2.http.GET

interface CitySchoolsApi {
    @GET("/resource/97mf-9njv.json")
    suspend fun getData(): List<School>
}