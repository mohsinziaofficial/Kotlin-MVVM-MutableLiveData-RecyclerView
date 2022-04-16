package com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.adapterClass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.dataClass.Users
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.databinding.ItemBinding

class MainActivityAdapter(private val clickListener : (Users) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {

    private val userList = ArrayList<Users>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(userList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserList(listOfAllUsers : List<Users>) {
        userList.clear()
        userList.addAll(listOfAllUsers)
    }
}

class MyViewHolder(private val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(userData : Users, clickListener: (Users) -> Unit) {
        binding.apply {
            Glide.with(itemView).load(userData.imgUrl).centerCrop().circleCrop().into(profileImg)
            name.text = userData.name
            email.text = userData.email
            root.setOnClickListener {
                clickListener(userData)
            }
        }
    }
}