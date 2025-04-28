package com.amar.practicemvvmretrofit.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amar.practicemvvmretrofit.common.Result
import com.amar.practicemvvmretrofit.data.model.User
import com.amar.practicemvvmretrofit.databinding.FragmentHomeBinding
import com.amar.practicemvvmretrofit.ui.adapter.UserAdapter
import com.amar.practicemvvmretrofit.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
     private lateinit var binding: FragmentHomeBinding
     private val viewmodel: UserViewModel by viewModels()
     private val userAdapter by lazy {
          UserAdapter { user ->
               showBottomSheet(user)
          }
     }

     override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
     ): View {
          binding = FragmentHomeBinding.inflate(inflater, container, false)
          return binding.root
     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)

          setUpRecyclerView()

          viewmodel.users.observe(viewLifecycleOwner) { result ->
               when (result) {
                    is Result.Loading -> {
                         binding.progressBar.visibility = View.VISIBLE
                         binding.recyclerView.visibility = View.GONE
                    }

                    is Result.Success -> {
                         binding.progressBar.visibility = View.GONE
                         binding.recyclerView.visibility = View.VISIBLE
                         userAdapter.submitList(result.data.users)
                    }

                    is Result.Failure -> {
                         binding.progressBar.visibility = View.GONE
                         binding.recyclerView.visibility = View.VISIBLE
                         Toast.makeText(context, result.error?.message ?: "Failure result", Toast.LENGTH_LONG).show()
                    }
               }
          }
     }

     private fun setUpRecyclerView() {
          binding.recyclerView.apply {
               layoutManager = LinearLayoutManager(requireContext())
               adapter = userAdapter
          }
     }

     private fun showBottomSheet(user: User) {
          val bottomSheetFragment = BottomSheetFragment.newInstance(user)
          bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
     }
}