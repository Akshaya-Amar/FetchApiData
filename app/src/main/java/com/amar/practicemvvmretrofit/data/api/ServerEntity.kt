package com.amar.practicemvvmretrofit.data.api

import com.google.gson.annotations.SerializedName

data class ServerEntity<T>(
     @SerializedName("data") val data: T? = null,
     @SerializedName("error") val error: ErrorEntity? = null
)