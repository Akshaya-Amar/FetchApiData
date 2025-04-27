package com.amar.practicemvvmretrofit.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.amar.practicemvvmretrofit.R
import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.api.RetrofitClient
import com.amar.practicemvvmretrofit.ui.viewmodel.UserViewModel
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

     private val viewModel: UserViewModel by viewModels()

     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_home)

          viewModel.users.observe(this) { result ->
               when (result) {
                    is Result.Loading -> {
                         Log.d("check...", "Loading")
                    }

                    is Result.Success -> {
                         Log.d("check...", "Success: ${result.data.users}")
                         Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                    }

                    is Result.Failure -> {
                         Log.d("check...", "Failure: ${result.error?.message}")
                         Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
                    }
               }
          }
     }
}