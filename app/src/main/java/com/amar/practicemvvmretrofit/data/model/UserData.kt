package com.amar.practicemvvmretrofit.data.model

import com.google.gson.annotations.SerializedName

data class UserData(
     @SerializedName("users") val users: List<User>? = null
)
