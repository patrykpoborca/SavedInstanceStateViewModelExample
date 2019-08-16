package com.koziodigital.myapplication.utility

import androidx.lifecycle.MutableLiveData
import com.koziodigital.myapplication.base.SavedStateProvider

public inline fun <reified T>lazyLiveLong(savedStateProvider: SavedStateProvider, key: String, defaultValue: T?): Lazy<MutableLiveData<T>> {
    return lazy<MutableLiveData<T>> {
        savedStateProvider.savedStateHandle().getLiveData(key, defaultValue)
    }
}

public inline fun <reified T> SavedStateProvider.lazyLive(key: String, defaultValue: T?): Lazy<MutableLiveData<T>> {
    return lazyLiveLong(this, key, defaultValue)
}