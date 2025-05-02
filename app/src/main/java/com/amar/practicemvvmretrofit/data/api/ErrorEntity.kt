package com.amar.practicemvvmretrofit.data.api

import com.google.gson.annotations.SerializedName

data class ErrorEntity(
     @SerializedName("code") val code: Int? = null,
     @SerializedName("title") val title: String? = null,
     @SerializedName("subtitle") val subtitle: String? = null,
     @SerializedName("message") val message: String? = null
)