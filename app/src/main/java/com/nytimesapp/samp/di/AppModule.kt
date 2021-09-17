package com.nytimesapp.samp.di

import com.nytimesapp.samp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
creates singleton object for base url and retrofit which will provide base url and retrofit api service
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesUrl() = "http://api.nytimes.com/svc/mostpopular/"

    @Provides
    @Singleton
    fun providesApiService(url: String): ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}