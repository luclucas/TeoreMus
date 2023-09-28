package com.lulu.teoremus.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.lulu.teoremus.model.Questao

class QuestoesRepositoryImpl constructor(private val document: String) {
    private val db = FirebaseFirestore.getInstance()
     fun getQuestoes(questoes: MutableLiveData<MutableList<Questao>>) {
        db.collection("Quiz").document(document)
            .collection("Questoes").get().addOnCompleteListener {

                if(it.isSuccessful){

                    questoes.value = it.result.toObjects(Questao::class.java)

                    }
                }

            .addOnFailureListener {
                Log.d("Lulutag", "Erro: ${it.message}")
            }


    }
}
