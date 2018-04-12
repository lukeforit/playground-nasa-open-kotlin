package com.rabbit.green.nasaopen.di

import android.content.Context
import com.rabbit.green.nasaopen.BuildConfig
import com.rabbit.green.nasaopen.IResourceProvider
import com.rabbit.green.nasaopen.LocalClientInterceptor
import com.rabbit.green.nasaopen.MockResourceProvider
import com.rabbit.green.nasaopen.data.source.IRepository
import com.rabbit.green.nasaopen.data.source.net.IRepositoryRestService
import com.rabbit.green.nasaopen.data.source.net.Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideResourceProvider(context: Context) : IResourceProvider {
        return MockResourceProvider(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(resourceProvider: IResourceProvider): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(LocalClientInterceptor(resourceProvider))
                .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
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