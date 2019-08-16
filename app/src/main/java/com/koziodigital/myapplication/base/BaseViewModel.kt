package com.koziodigital.myapplication.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import com.koziodigital.myapplication.utility.SomeRepository

open class BaseViewModel(application: Application, val someRepository: SomeRepository): AndroidViewModel(application), SavedStateProvider {
    // is initialized by the CustomSavedStateFactory
    lateinit var _savedStateHandle: SavedStateHandle

    override fun savedStateHandle(): SavedStateHandle = _savedStateHandle
}