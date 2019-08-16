package com.koziodigital.myapplication.dagger

import androidx.appcompat.app.AppCompatActivity
import com.koziodigital.myapplication.base.BaseActivity

interface SharedScreenDependencies: SharedDependencies {
    fun activity(): AppCompatActivity
    fun baseActivity(): BaseActivity<*>
}