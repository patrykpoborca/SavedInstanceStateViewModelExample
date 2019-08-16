package com.koziodigital.myapplication.dagger
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.koziodigital.myapplication.base.BaseViewModel
import dagger.Lazy
import javax.inject.Inject

class CustomSavedStateVMFactory<VM: BaseViewModel> @Inject constructor(private val viewModel: Lazy<VM>, owner: SavedStateRegistryOwner, defaultargs: Bundle?): AbstractSavedStateViewModelFactory(owner, defaultargs) {


    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        val temp = viewModel.get()
        temp._savedStateHandle = handle
        return temp as T
    }

}