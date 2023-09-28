package com.lulu.teoremus.view

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.lulu.teoremus.model.User
import com.lulu.teoremus.utils.SHARED_USER_KEY

class MainActivityViewModel : ViewModel() {

    val user = MutableLiveData<MutableSet<User>>()
    val isSuccessful = MutableLiveData(false)


    fun getCurrentUser(context: Context) {
        val db = FirebaseFirestore.getInstance()
        val firebaseAuth = FirebaseAuth.getInstance()
        val userId = firebaseAuth.currentUser!!.uid
        val userRef = db.collection("Usuarios").document(userId)
        userRef.get().addOnCompleteListener {
            if (it.isSuccessful) {

                Log.d("lulutag","result ${it.result.data}")

                val nome = it.result.data!!["nome"].toString()
                val email = it.result.data!!["email"].toString()
                val moduloI = it.result.data!!["moduloI"].toString().toInt()
                val moduloII = it.result.data!!["moduloII"].toString().toInt()
                val moduloIII = it.result.data!!["moduloIII"].toString().toInt()
                val moduloIV = it.result.data!!["moduloIV"].toString().toInt()
                val total = it.result.data!!["total"].toString().toInt()



                user.value!!.add(User(nome, email, moduloI, moduloII, moduloIII, moduloIV, total))
                isSuccessful.value = true
            }
//            user.value!!.nome = it!!["nome"].toString()
//            user.value!!.email = it["email"].toString()
//            user.value!!.moduloI = it["moduloI"].toString().toInt()
//            user.value!!.moduloII = it["moduloII"].toString().toInt()
//            user.value!!.moduloIII = it["moduloIII"].toString().toInt()
//            user.value!!.moduloIV = it["moduloIV"].toString().toInt()
//            user.value!!.total = it["total"].toString().toInt()
        }

    }
}