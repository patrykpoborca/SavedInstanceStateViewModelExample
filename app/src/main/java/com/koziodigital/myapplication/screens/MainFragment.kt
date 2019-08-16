package com.koziodigital.myapplication.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koziodigital.myapplication.base.BaseFragment
import com.koziodigital.myapplication.databinding.FrCounterBinding

class MainFragment: BaseFragment<MainFragmentViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentComponent.inject(this)
    }

    override fun getVMKlazz() = MainFragmentViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FrCounterBinding.inflate(layoutInflater,container, false)
        binding.vm = vm
        binding.lifecycleOwner = this
        return binding.root
    }
}
