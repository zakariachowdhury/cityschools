package com.zakariachowdhury.cityschools

import javax.inject.Inject

class SchoolRepository @Inject constructor(
    private var citySchoolsApi: CitySchoolsApi
) {
    suspend fun getSchools() = citySchoolsApi.getData()
}