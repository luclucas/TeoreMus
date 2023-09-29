package com.lulu.teoremus.data

import android.content.Context
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, senha: String, context: Context): Resource<FirebaseUser>
    suspend fun criarConta(nome: String, email: String, senha: String, context: Context): Resource<FirebaseUser>
    fun logout()
}