package com.gubo.duszaverseny.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmailVerifyViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _generatedCode = MutableLiveData<Int>()
    val generatedCode: LiveData<Int> = _generatedCode

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updateGeneratedCode(newCode: Int) {
        _generatedCode.value = newCode
    }

    fun generateRandomCode(): Int = (100_000..999_999).random()
}