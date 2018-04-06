package com.rabbit.green.nasaopen.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rabbit.green.nasaopen.MainActivity

@Module
abstract class ActivityContributorModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}