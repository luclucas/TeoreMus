package com.lulu.teoremus.view.ranking

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import com.lulu.teoremus.model.User

class RankingViewModel: ViewModel() {
    val usersList = MutableLiveData<List<User>>()
    val isOk = MutableLiveData(false)

//    init {
//        getUsers()
//    }


     fun getUsers(): Boolean{
        val db = FirebaseFirestore.getInstance()

    db.collection("Usuarios").orderBy("total", Query.Direction.DESCENDING).get().addOnSuccessListener {
            val list = mutableListOf<User>()
            Log.d("lulutag", "${it.documents}")
            for (document in it){

                val user = document.toObject<User>()
                list.add(user)

                Log.d("lulutag", user.toString())
                Log.d("lulutag", document.data.values.toString())

            }
        usersList.value = list
        Log.d("lulutag", "userlist = $usersList")
        isOk.value = true
        }
        return isOk.value!!
    }
}