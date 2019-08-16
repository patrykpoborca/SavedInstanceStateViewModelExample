package com.koziodigital.myapplication.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.koziodigital.myapplication.dagger.CustomSavedStateVMFactory
import com.koziodigital.myapplication.dagger.DaggerFragmentComponent
import com.koziodigital.myapplication.dagger.FragmentModule
import com.koziodigital.myapplication.utility.BookingViewModel
import javax.inject.Inject

abstract class BaseFragment<T: BaseViewModel>: Fragment() {

    val fragmentComponent by lazy {
        return@lazy DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule(this))
            .sharedScreenDependencies((activity as BaseActivity<*>).activityComponent)
            .build()
    }

    @Inject
    lateinit var _viewModelProvider: CustomSavedStateVMFactory<T>

    val bookingViewModel: BookingViewModel
        get() = (activity as BaseActivity<*>).bookingViewModel

    val vm: T by lazy {
        ViewModelProvider(this, _viewModelProvider).get(getVMKlazz())
    }

    abstract fun getVMKlazz(): Class<T>

}