package com.zakariachowdhury.cityschools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository
) : ViewModel() {
    val citySchoolsHashMap = liveData(Dispatchers.IO) {
        val fetchedSchools = schoolRepository.getSchools()

        var hashMap: HashMap<String, ArrayList<String>> = HashMap()

        for (school in fetchedSchools) {
            if (hashMap.get(school.city) == null) {
                hashMap.put(school.city, ArrayList())
            }
            var citySchools = hashMap.get(school.city)
            citySchools?.add(school.school_name)
        }

        emit(hashMap)
    }
}