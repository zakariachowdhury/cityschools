package com.zakariachowdhury.cityschools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository: Repository = Repository()

    val schools = liveData(Dispatchers.IO) {
        val fetchedSchools = repository.getSchools()
        emit(fetchedSchools)
    }
}