package com.vocationalsubject.skillsubai.authentication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {
    suspend fun saveStudentProfile(profile: StudentProfile) {
        val uid = auth.currentUser?.uid ?: return
        firestore.collection("students").document(uid)
            .set(profile.copy(uid = uid))
            .await()
    }

    fun isUserLoggedIn(): Boolean = auth.currentUser != null
}
