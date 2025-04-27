package com.amar.practicemvvmretrofit.data.repository

import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.api.ApiService
import com.amar.practicemvvmretrofit.data.api.RetrofitClient
import com.amar.practicemvvmretrofit.data.model.UserData
import com.amar.practicemvvmretrofit.util.safeApiCall

class UserRepositoryImpl(
     private val apiService: ApiService = RetrofitClient.apiService
) : UserRepository {
     override suspend fun getUsers(): Result<UserData> = safeApiCall { apiService.fetchUsers() }
}