package com.amar.practicemvvmretrofit.data.api

import com.amar.practicemvvmretrofit.data.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
//     @GET("/users")
     @GET("https://run.mocky.io/v3/f98d971e-cc53-458c-ad54-815b4e2c3a5e")
//     @GET("https://run.mocky.io/v3/19b96e83-6535-406e-94a4-af31ec3675f9")
     suspend fun fetchUsers(): Response<ServerEntity<UserData>>
}