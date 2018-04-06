package com.rabbit.green.nasaopen.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import test.kotlin_time.BuildConfig
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

}