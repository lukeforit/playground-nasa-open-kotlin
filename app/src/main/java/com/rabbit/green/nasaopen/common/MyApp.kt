package com.rabbit.green.nasaopen.common

import android.app.Activity
import android.app.Application
import com.rabbit.green.nasaopen.di.DaggerMyAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import com.rabbit.green.nasaopen.di.MyAppComponent
import javax.inject.Inject

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var injector : DispatchingAndroidInjector<Activity>

    val myAppComponent : MyAppComponent by lazy {
        DaggerMyAppComponent.builder()
                .myAppModule(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        myAppComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }
}