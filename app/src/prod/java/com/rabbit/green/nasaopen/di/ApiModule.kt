package com.rabbit.green.nasaopen.di

import com.rabbit.green.nasaopen.BuildConfig
import com.rabbit.green.nasaopen.data.source.IRepository
import com.rabbit.green.nasaopen.data.source.net.IRepositoryRestService
import com.rabbit.green.nasaopen.data.source.net.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideRepositoryRestService(retrofit: Retrofit): IRepositoryRestService {
        return retrofit.create(IRepositoryRestService::class.java)
    }
    @Provides
    @Singleton
    fun provideRepository(service: IRepositoryRestService): IRepository {
        return Repository(service)
    }

}