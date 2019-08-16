package com.koziodigital.myapplication.screens

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.koziodigital.myapplication.base.BaseViewModel
import com.koziodigital.myapplication.utility.BookingViewModel
import com.koziodigital.myapplication.utility.SomeRepository
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(application: Application, someRepository: SomeRepository, val bookingViewModel: BookingViewModel): BaseViewModel(application, someRepository) {

    val localVal: MutableLiveData<String> = MutableLiveData("0")

    fun bump() {
        bookingViewModel.bump()
        localVal.value = localVal.value?.toInt()?.plus(1)?.toString()
    }
}
