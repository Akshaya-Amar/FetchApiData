package com.amar.practicemvvmretrofit.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amar.practicemvvmretrofit.data.model.User
import com.amar.practicemvvmretrofit.databinding.UserItemBinding

class UserAdapter(
     private val onItemClick: (User) -> Unit
) : ListAdapter<User, UserAdapter.UserViewHolder>(DiffCallBack()) {

     class DiffCallBack : DiffUtil.ItemCallback<User>() {
          override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
               return oldItem.id == newItem.id
          }

          override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
               return oldItem == newItem
          }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
          val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return UserViewHolder(binding)
     }

     override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
          val user = getItem(position)
          holder.onBind(user, onItemClick)
     }

     class UserViewHolder(
          private val binding: UserItemBinding
     ) : RecyclerView.ViewHolder(binding.root) {
          fun onBind(user: User, onItemClick: (User) -> Unit) {
               with(binding) {
                    val completeName = "${user.firstName} ${user.lastName}"
                    nameTextView.text = completeName
                    emailTextView.text = user.email
                    phoneTextView.text = user.phoneNumber
                    root.setOnClickListener {
                         onItemClick(user)
                    }
               }
          }
     }
}