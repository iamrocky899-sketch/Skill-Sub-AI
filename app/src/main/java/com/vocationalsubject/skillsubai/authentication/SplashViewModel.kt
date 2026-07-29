package com.vocationalsubject.skillsubai.authentication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    fun isUserLoggedIn(): Boolean = repository.isUserLoggedIn()
}
