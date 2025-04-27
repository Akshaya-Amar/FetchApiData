package com.amar.practicemvvmretrofit.data.api

import com.amar.practicemvvmretrofit.data.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
//     @GET("/users")
     @GET("https://raw.githubusercontent.com/Akshaya-Amar/FetchApiData/refs/heads/master/json/users.json")
//     @GET("https://raw.githubusercontent.com/Akshaya-Amar/FetchApiData/refs/heads/master/json/error.json")
     suspend fun fetchUsers(): Response<ServerEntity<UserData>>
}