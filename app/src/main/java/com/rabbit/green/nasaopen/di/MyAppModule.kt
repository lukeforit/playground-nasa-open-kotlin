package com.rabbit.green.nasaopen.di

import android.content.Context
import com.rabbit.green.nasaopen.common.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(ApiModule::class))
class MyAppModule {
    @Provides
    @Singleton
    fun provideContext(myApp: MyApp): Context {
        return myApp.baseContext
    }
}