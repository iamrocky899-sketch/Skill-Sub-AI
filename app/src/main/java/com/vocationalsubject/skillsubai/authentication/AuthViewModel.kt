package com.vocationalsubject.skillsubai.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    private val _studentProfile = MutableStateFlow(StudentProfile())
    val studentProfile: StateFlow<StudentProfile> = _studentProfile

    fun updateName(name: String) {
        _studentProfile.value = _studentProfile.value.copy(name = name)
    }

    fun updateSchool(school: String) {
        _studentProfile.value = _studentProfile.value.copy(school = school)
    }

    fun updateClass(studentClass: String) {
        _studentProfile.value = _studentProfile.value.copy(studentClass = studentClass)
    }

    fun updateLanguage(language: String) {
        _studentProfile.value = _studentProfile.value.copy(language = language)
    }

    fun updateTrade(trade: String) {
        _studentProfile.value = _studentProfile.value.copy(trade = trade)
    }

    fun saveProfile() {
        viewModelScope.launch {
            try {
                repository.saveStudentProfile(_studentProfile.value)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
