package com.koziodigital.myapplication.base

import androidx.lifecycle.SavedStateHandle

interface SavedStateProvider {
    fun savedStateHandle(): SavedStateHandle
}