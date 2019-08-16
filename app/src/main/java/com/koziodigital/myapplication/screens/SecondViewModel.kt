package com.koziodigital.myapplication.screens

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.koziodigital.myapplication.base.BaseViewModel
import com.koziodigital.myapplication.utility.BookingViewModel
import com.koziodigital.myapplication.utility.SomeRepository
import com.koziodigital.myapplication.utility.lazyLive
import com.koziodigital.myapplication.utility.lazyLiveLong
import javax.inject.Inject

class SecondViewModel @Inject constructor(val bookingViewModel: BookingViewModel, application: Application, someRepository: SomeRepository): BaseViewModel(application, someRepository) {

    val localVal: MutableLiveData<String> by lazyLive("localVal2", "0")

    fun bump() {
        bookingViewModel.bump()
        bookingViewModel.bump()
        localVal.value = localVal.value?.toInt()?.plus(2)?.toString()
    }

}
