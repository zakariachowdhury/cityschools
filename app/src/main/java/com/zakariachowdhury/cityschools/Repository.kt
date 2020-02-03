package com.zakariachowdhury.cityschools

class Repository {
    private var client: CitySchoolsApi = RetrofitClient.citySchoolsApi

    suspend fun getSchools() = client.getData()
}