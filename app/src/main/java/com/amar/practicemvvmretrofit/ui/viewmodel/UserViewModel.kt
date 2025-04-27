package com.amar.practicemvvmretrofit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.model.UserData
import com.amar.practicemvvmretrofit.data.repository.UserRepository
import com.amar.practicemvvmretrofit.data.repository.UserRepositoryImpl
import kotlinx.coroutines.launch

class UserViewModel(
     private val repo: UserRepository = UserRepositoryImpl()
) : ViewModel() {
     private var _users = MutableLiveData<Result<UserData>>(Result.Loading)
     val users: LiveData<Result<UserData>> get() = _users

     init {
          viewModelScope.launch {
               val data = repo.getUsers()
               _users.postValue(data)
          }
     }
}