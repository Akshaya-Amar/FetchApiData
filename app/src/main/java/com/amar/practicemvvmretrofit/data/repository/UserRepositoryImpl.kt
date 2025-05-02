package com.amar.practicemvvmretrofit.data.repository

import android.content.Context
import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.api.ApiService
import com.amar.practicemvvmretrofit.data.model.UserData
import com.amar.practicemvvmretrofit.util.safeApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
     private val apiService: ApiService,
     @ApplicationContext private val context: Context
) : UserRepository {
     override suspend fun getUsers(): Result<UserData> = safeApiCall(context) { apiService.fetchUsers() }
}