package com.lulu.teoremus.data

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.lulu.teoremus.utils.SHARED_USER_KEY
import com.lulu.teoremus.utils.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, senha: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, senha).await()
            Resource.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }

    }

    override suspend fun criarConta(
        nome: String,
        email: String,
        senha: String,
        context: Context
    ): Resource<FirebaseUser> {
        return try {
            val result =
                firebaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                    val pontosIniciais = 0
                    val userId = firebaseAuth.currentUser!!.uid
                    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
                    val userRef = db.collection("Usuarios").document(userId)
                    val user = mapOf(
                        "nome" to nome,
                        "email" to email,
                        "moduloI" to pontosIniciais,
                        "moduloII" to pontosIniciais,
                        "moduloIII" to pontosIniciais,
                        "moduloIV" to pontosIniciais,
                        "total" to pontosIniciais
                    )
                    userRef.set(user).addOnSuccessListener {
                        Log.d("lulutag", "Sucesso para o usuario: $userId")
                    }

                    val sharedPreferences = context.getSharedPreferences(SHARED_USER_KEY, Context.MODE_PRIVATE)
                    val edit = sharedPreferences.edit()
                    edit.putInt("moduloI", pontosIniciais)
                    edit.putInt("moduloII",  pontosIniciais)
                    edit.putInt("moduloIII",  pontosIniciais)
                    edit.putInt("moduloIV",  pontosIniciais)
                    edit.putInt("total", pontosIniciais)
                    edit.apply()

                }.await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().build())
            Resource.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}