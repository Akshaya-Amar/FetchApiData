package com.amar.practicemvvmretrofit.data.repository

import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.api.ApiService
import com.amar.practicemvvmretrofit.data.model.UserData
import com.amar.practicemvvmretrofit.util.ResourceProvider
import com.amar.practicemvvmretrofit.util.safeApiCall
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
     private val apiService: ApiService,
     private val resourceProvider: ResourceProvider
) : UserRepository {
     override suspend fun getUsers(): Result<UserData> = safeApiCall(resourceProvider) { apiService.fetchUsers() }
}