package com.itronix.mvvmloginregistrationvolleykotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itronix.mvvmloginregistrationvolleykotlin.MyApplication
import com.itronix.mvvmloginregistrationvolleykotlin.network.AuthRepository

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository(MyApplication.getAppContext())
    private val _authResponse = MutableLiveData<String>()
    val authResponse: LiveData<String> get() = _authResponse

    fun login(email: String, password: String) {
        repository.login(email, password) { response ->
            _authResponse.postValue(response)
        }
    }

    fun register(email: String, password: String) {
        repository.register(email, password) { response ->
            _authResponse.postValue(response)
        }
    }
}