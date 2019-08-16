package com.koziodigital.myapplication.dagger

import android.app.Application
import android.content.Context
import com.koziodigital.myapplication.utility.SomeRepository

interface SharedDependencies {
    fun app(): Application
    fun ctx(): Context
    fun someRepo(): SomeRepository
}
