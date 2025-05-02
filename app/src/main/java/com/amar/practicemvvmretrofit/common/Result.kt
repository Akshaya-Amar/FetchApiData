package com.amar.practicemvvmretrofit.common

import com.amar.practicemvvmretrofit.data.api.ErrorEntity

sealed class Result<out T> {
     data class Success<T>(val data: T) : Result<T>()
     data class Failure(val error: ErrorEntity?) : Result<Nothing>()
     data object Loading : Result<Nothing>()
}