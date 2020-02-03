package com.zakariachowdhury.cityschools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository
) : ViewModel() {
    val schools = liveData(Dispatchers.IO) {
        val fetchedSchools = schoolRepository.getSchools()
        emit(fetchedSchools)
    }
}