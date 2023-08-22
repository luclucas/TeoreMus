package com.lulu.teoremus.data

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, senha: String): Resource<FirebaseUser>
    suspend fun criarConta(email: String, senha: String): Resource<FirebaseUser>
    fun logout()
}