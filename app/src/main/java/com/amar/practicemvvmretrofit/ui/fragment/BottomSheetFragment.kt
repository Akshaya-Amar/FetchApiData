package com.amar.practicemvvmretrofit.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.amar.practicemvvmretrofit.R
import com.amar.practicemvvmretrofit.data.model.User
import com.amar.practicemvvmretrofit.databinding.BottomSheetItemBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

     private lateinit var binding: BottomSheetItemBinding

     override fun onCreateView(
          inflater: LayoutInflater,
          container: ViewGroup?,
          savedInstanceState: Bundle?
     ): View {
          binding = BottomSheetItemBinding.inflate(inflater, container, false)
          return binding.root
     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)

          val userData: User? = arguments?.getParcelable(USER_DATA)

          userData?.let { user ->
               val unknown = getString(R.string.unknown_value)
               val address = user.address
               val userInfo = buildString {
                    appendLine("ID: ${user.id ?: unknown}")
                    appendLine("Name: ${user.firstName ?: unknown} ${user.lastName}")
                    appendLine("Age: ${user.age ?: unknown}")
                    appendLine("Email: ${user.email ?: unknown}")
                    appendLine("Phone Number: ${user.phoneNumber ?: unknown}")
                    appendLine("Address: ${address?.address}, ${address?.state}, ${address?.city}, ${address?.postalCode}")
               }

               binding.userInfoTextView.text = userInfo
          }
     }

     companion object {
          private const val USER_DATA = "user_data"
          fun newInstance(user: User): BottomSheetFragment = BottomSheetFragment().apply {
               arguments = bundleOf(USER_DATA to user)
          }
     }
}