package com.koziodigital.myapplication.utility

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.koziodigital.myapplication.base.BaseViewModel
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class BookingViewModel(application: Application, someRepository: SomeRepository): BaseViewModel(application, someRepository) {


    val count by lazyLive("count", "0")

    fun bump() {
        count.value = count.value?.toInt()?.plus(1)?.toString()
    }

    fun toast() = Toast.makeText(getApplication(), "Count = ${count.value}", Toast.LENGTH_LONG).show()
}


inline fun <reified T> SavedStateHandle.slivedate(key: String? = null, initialValue: T? = null) = object : ReadOnlyProperty<Any, MutableLiveData<T?>> {
    override fun getValue(thisRef: Any, property: KProperty<*>): MutableLiveData<T?> {
        val stateKey = key ?: property.name
        return if (initialValue == null) {
            this@slivedate.getLiveData(stateKey)
        } else {
            this@slivedate.getLiveData(stateKey, initialValue)
        }
    }
}


