package com.koziodigital.myapplication

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.koziodigital.myapplication.base.BaseActivity
import com.koziodigital.myapplication.databinding.ActivityMainBinding
import com.koziodigital.myapplication.screens.MainFragment
import com.koziodigital.myapplication.screens.SecondFragment

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = vm


//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container, MainFragment())
//            replace(R.id.fragment_container_two, SecondFragment())
//            commit()
//        }
    }

    override fun getVMKlazz(): Class<MainActivityViewModel> = MainActivityViewModel::class.java
}
