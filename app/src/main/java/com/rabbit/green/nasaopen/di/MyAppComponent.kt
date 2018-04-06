package com.rabbit.green.nasaopen.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import com.rabbit.green.nasaopen.common.MyApp

@Component(modules = arrayOf(
        MyAppModule::class,
        AndroidInjectionModule::class,
        ActivityContributorModule::class
))
interface MyAppComponent {

    fun inject(app: MyApp)

    @Component.Builder
    interface Builder {

        fun build(): MyAppComponent

        @BindsInstance
        fun myAppModule(myApp: MyApp): Builder
    }
}