package com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammadmohsinzia.mvvm_mutablelivedata_recyclerview.dataClass.Users

class UsersViewModel : ViewModel(){
    var userMutableDataList = MutableLiveData<List<Users>>()
    val userLiveDataList : LiveData<List<Users>> = userMutableDataList

    fun getUsers() {
        var userList = mutableListOf<Users>(
            Users("Mohsin", "mohsin@gmail.com", "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg"),
            Users("Salman", "salman@gmail.com", "https://t4.ftcdn.net/jpg/03/64/21/11/360_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg"),
            Users("Honey", "honey@gmail.com", "https://d2qp0siotla746.cloudfront.net/img/use-cases/profile-picture/template_0.jpg"),
            Users("Ahsan", "ahsan@gmail.com", "https://expertphotography.b-cdn.net/wp-content/uploads/2020/08/social-media-profile-photos-3.jpg"),
            Users("Saiqa", "saiqa@gmail.com", "https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg.jpg"),
            Users("Aiza", "aiza@gmail.com", "https://dev.codingambitions.com/android/tutorials/images/user1.jpg"),
        )

        userMutableDataList.value = userList
    }
}