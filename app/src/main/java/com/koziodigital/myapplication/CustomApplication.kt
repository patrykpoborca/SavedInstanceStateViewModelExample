package com.koziodigital.myapplication

import android.app.Application
import com.koziodigital.myapplication.dagger.ApplicationModule
import com.koziodigital.myapplication.dagger.DaggerApplicationComponent

class CustomApplication: Application() {

    val appComponent = lazy {
        return@lazy DaggerApplicationComponent
            .builder().applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}