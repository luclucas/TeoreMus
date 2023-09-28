package com.lulu.teoremus.view.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.lulu.teoremus.data.AuthRepository
import com.lulu.teoremus.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _criarContaFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val criarContaFlow: StateFlow<Resource<FirebaseUser>?> = _criarContaFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _loginFlow.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun login(email: String, senha: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading
        val result = repository.login(email, senha)
        _loginFlow.value = result
    }

    fun criarConta(nome: String, email: String, senha: String, context: Context) = viewModelScope.launch {
        val db: FirebaseFirestore
      //  val userRef = db.collection("Usuarios").document()


        _criarContaFlow.value = Resource.Loading
        val result = repository.criarConta(nome, email, senha, context)
        _criarContaFlow.value = result
    }

    fun logout() {
        repository.logout()
        _loginFlow.value = null
        _criarContaFlow.value = null
    }
}