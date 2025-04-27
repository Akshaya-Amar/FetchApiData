package com.amar.practicemvvmretrofit.util

import android.util.Log
import com.amar.practicemvvmretrofit.common.ErrorEntity
import com.amar.practicemvvmretrofit.data.api.ServerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import com.amar.practicemvvmretrofit.common.Result

suspend fun <T> safeApiCall(
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
                              message = error?.message ?: "Unknown Error"
                         )
                    )
               }
          } else {
               Log.d("check...repo", "Failure; Not successful")
               Result.Failure(ErrorEntity(message = response.message() ?: "Something went wrong"))
          }
     } catch (exception: Exception) {
          Log.d("check...repo", "Failure Exception")
          Result.Failure(ErrorEntity(message = exception.localizedMessage ?: "Something went wrong"))
     }
}