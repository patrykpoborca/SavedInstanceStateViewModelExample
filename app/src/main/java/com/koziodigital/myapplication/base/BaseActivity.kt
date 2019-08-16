package com.koziodigital.myapplication.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.koziodigital.myapplication.CustomApplication
import com.koziodigital.myapplication.dagger.ActivityModule
import com.koziodigital.myapplication.dagger.CustomSavedStateVMFactory
import com.koziodigital.myapplication.dagger.DaggerActivityComponent
import com.koziodigital.myapplication.utility.BookingViewModel
import javax.inject.Inject

abstract class BaseActivity<T: BaseViewModel>: AppCompatActivity() {

    val activityComponent by lazy {
        return@lazy DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as CustomApplication).appComponent.value)
            .build()
    }

    @Inject
    lateinit var _viewModelProvider: CustomSavedStateVMFactory<T>

    @Inject
    lateinit var _bookingProvider: CustomSavedStateVMFactory<BookingViewModel>

    val bookingViewModel: BookingViewModel by lazy {
        ViewModelProvider(this, _bookingProvider).get(BookingViewModel::class.java)
    }

    val vm: T by lazy {
        ViewModelProvider(this, _viewModelProvider).get(getVMKlazz())
    }

    abstract fun getVMKlazz(): Class<T>
}