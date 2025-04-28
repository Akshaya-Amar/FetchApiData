package com.amar.practicemvvmretrofit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.model.UserData
import com.amar.practicemvvmretrofit.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
     private val repo: UserRepository
) : ViewModel() {
     private var _users = MutableLiveData<Result<UserData>>(Result.Loading)
     val users: LiveData<Result<UserData>> get() = _users

     init {
          getUsers()
     }

     private fun getUsers() {
          viewModelScope.launch {
               val data = repo.getUsers()
               _users.postValue(data)
          }
     }
}