package com.amar.practicemvvmretrofit.util

import android.content.Context
import android.util.Log
import com.amar.practicemvvmretrofit.R
import com.amar.practicemvvmretrofit.data.api.ErrorEntity
import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.api.ServerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T> safeApiCall(
     context: Context,
     apiCall: suspend () -> Response<ServerEntity<T>>
): Result<T> = withContext(Dispatchers.IO) {
     try {
          val response = apiCall()
          if (response.isSuccessful) {
               Log.d("check...repo", "Successful")
               val body = response.body()
               body?.data?.let {
                    Log.d("check...repo", "Successful: Data -> $it")
                    Result.Success(it)
               } ?: run {
                    val error = body?.error
                    Log.d("check...repo", "Successful: Error -> $error")
                    Result.Failure(
                         ErrorEntity(
                              code = error?.code,
                              title = error?.title,
                              subtitle = error?.subtitle,
                              message = error?.message ?: context.getString(R.string.error_unknown)
                         )
                    )
               }
          } else {
               Log.d("check...repo", "Failure; Not successful ${response.message().isEmpty()}")
               Result.Failure(ErrorEntity(message = response.message().takeIf { it.isNullOrEmpty().not() } ?: context.getString(R.string.error_something_went_wrong)))
          }
     } catch (exception: Exception) {
          Log.d("check...repo", "Failure Exception: ${exception.localizedMessage}")
          Result.Failure(mapExceptionToErrorEntity(exception, context))
     }
}

private fun mapExceptionToErrorEntity(
     exception: Exception,
     context: Context
): ErrorEntity {
     return when (exception) {
          is UnknownHostException -> {
               ErrorEntity(message = context.getString(R.string.error_no_internet))
          }

          is SocketTimeoutException -> {
               ErrorEntity(message = context.getString(R.string.error_timeout))
          }

          is IOException -> {
               ErrorEntity(message = context.getString(R.string.error_io))
          }

          is HttpException -> {
               ErrorEntity(message = exception.message() ?: context.getString(R.string.error_something_went_wrong))
          }

          else -> {
               ErrorEntity(message = context.getString(R.string.error_unknown))
          }
     }
}
