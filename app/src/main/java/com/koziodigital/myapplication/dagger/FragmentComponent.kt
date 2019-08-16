package com.koziodigital.myapplication.dagger

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.savedstate.SavedStateRegistryOwner
import com.koziodigital.myapplication.base.BaseActivity
import com.koziodigital.myapplication.screens.MainFragment
import com.koziodigital.myapplication.screens.SecondFragment
import dagger.Component
import dagger.Module
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [SharedScreenDependencies::class])
interface FragmentComponent: SharedScreenDependencies {

    fun inject(mainFragment: MainFragment)
    fun inject(secondFragment: SecondFragment)
}

@Module
class FragmentModule(val fragment: Fragment) {

    @Provides
    fun pFragment(): Fragment = fragment

    @Provides
    fun pOwner(): SavedStateRegistryOwner = fragment

    @Provides
    @Nullable
    fun pBundle(): Bundle? = fragment.arguments

    @Provides
    fun pBookingVM(activity: BaseActivity<*>) = activity.bookingViewModel

}


@Scope
@Retention(RetentionPolicy.SOURCE)
annotation class FragmentScope