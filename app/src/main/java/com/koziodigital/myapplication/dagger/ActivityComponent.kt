package com.koziodigital.myapplication.dagger

import android.app.Application
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.savedstate.SavedStateRegistryOwner
import com.koziodigital.myapplication.MainActivity
import com.koziodigital.myapplication.base.BaseActivity
import com.koziodigital.myapplication.utility.BookingViewModel
import com.koziodigital.myapplication.utility.SomeRepository
import dagger.Component
import dagger.Module
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent: SharedScreenDependencies {

    fun inject(mainActivity: MainActivity)
}

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun pActivity(): AppCompatActivity = activity

    @Provides
    fun pBaseActivity(): BaseActivity<*> = activity as BaseActivity<*>

    @Provides
    fun pOwner(): SavedStateRegistryOwner = activity

    @Provides
    @Nullable
    fun pBundle(): Bundle? = activity.intent.extras

    @Provides
    @ActivityScope
    fun pBookingVM(application: Application, someRepository: SomeRepository) = BookingViewModel(application, someRepository)

}


@Scope
@Retention(RetentionPolicy.SOURCE)
annotation class ActivityScope