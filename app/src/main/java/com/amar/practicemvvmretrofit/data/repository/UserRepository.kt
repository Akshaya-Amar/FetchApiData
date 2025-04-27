package com.amar.practicemvvmretrofit.data.repository

import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.model.UserData

interface UserRepository {
     suspend fun getUsers(): Result<UserData>
}