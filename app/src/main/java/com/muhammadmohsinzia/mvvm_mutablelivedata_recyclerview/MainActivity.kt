package com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.adapterClass.MainActivityAdapter
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.dataClass.Users
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.databinding.ActivityMainBinding
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.viewModel.UsersViewModel


class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel : UsersViewModel
    private val mainAdapter by lazy {
        MainActivityAdapter() {
                selectedItem : Users -> itemClicked(selectedItem)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mainAdapter
            }
        }

        userViewModel = ViewModelProvider(this)[UsersViewModel::class.java]
        userViewModel.getUsers()
        userViewModel.userLiveDataList.observe(this, Observer {
            Log.i("MyTag", "List of all Users : $it")
            mainAdapter.setUserList(it)
//            mainAdapter.notifyDataSetChanged() // for adding user into recyclerview on runtime
        })
    }

    fun itemClicked(user : Users) {
        Toast.makeText(this, "${user.name}", Toast.LENGTH_SHORT).show()
    }
}