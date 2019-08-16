package com.koziodigital.myapplication.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koziodigital.myapplication.base.BaseFragment
import com.koziodigital.myapplication.databinding.FrCounterTwoBinding

class SecondFragment: BaseFragment<SecondViewModel>() {

    override fun getVMKlazz(): Class<SecondViewModel> = SecondViewModel::class.java

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FrCounterTwoBinding.inflate(inflater, container, false)
        binding.vm = vm
        binding.lifecycleOwner = this
        return binding.root
    }
}