package com.koziodigital.myapplication

import android.app.Application
import com.koziodigital.myapplication.base.BaseViewModel
import com.koziodigital.myapplication.utility.BookingViewModel
import com.koziodigital.myapplication.utility.SomeRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val bookingViewModel: BookingViewModel, application: Application, someRepository: SomeRepository): BaseViewModel(application, someRepository) {

    fun print() {
        bookingViewModel.toast()
    }
}
