package com.zakariachowdhury.cityschools

import android.app.Application
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}

class MyApplication: Application() {
    val appComponent = DaggerApplicationComponent.create()
}