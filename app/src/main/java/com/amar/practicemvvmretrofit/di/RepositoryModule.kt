package com.amar.practicemvvmretrofit.di

import com.amar.practicemvvmretrofit.data.repository.UserRepository
import com.amar.practicemvvmretrofit.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

     @Binds
     abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}