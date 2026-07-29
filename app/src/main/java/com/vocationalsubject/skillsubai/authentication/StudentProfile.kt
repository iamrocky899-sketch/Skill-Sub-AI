package com.vocationalsubject.skillsubai.authentication

data class StudentProfile(
    val uid: String = "",
    val name: String = "",
    val school: String = "",
    val studentClass: String = "",
    val language: String = "",
    val trade: String? = null
)
