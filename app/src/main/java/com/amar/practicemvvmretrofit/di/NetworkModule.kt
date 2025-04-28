package com.amar.practicemvvmretrofit.di

import com.amar.practicemvvmretrofit.common.Constants.BASE_URL
import com.amar.practicemvvmretrofit.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

     @Provides
     @Singleton
     fun provideRetrofit(): Retrofit {
          return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
     }

     @Provides
     @Singleton
     fun provideApiService(
          retrofit: Retrofit
     ): ApiService {
          return retrofit.create(ApiService::class.java)
     }
}