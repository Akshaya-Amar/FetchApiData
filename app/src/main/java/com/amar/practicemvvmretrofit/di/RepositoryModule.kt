package com.amar.practicemvvmretrofit.di

import com.amar.practicemvvmretrofit.data.repository.UserRepository
import com.amar.practicemvvmretrofit.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

     @Binds
     @Singleton
     abstract fun bindUserRepository(
          userRepositoryImpl: UserRepositoryImpl
     ): UserRepository
}