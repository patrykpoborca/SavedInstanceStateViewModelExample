package com.koziodigital.myapplication.dagger

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent: SharedDependencies {

}

@Module
class  ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    fun app(): Application {
        return application
    }

    @Provides
    @Singleton
    fun context(): Context = application
}