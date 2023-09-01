package com.lulu.teoremus.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.lulu.teoremus.model.Questao

//constructor(val onLoad: (list: MutableList<Questao>)-> Unit)
class QuestoesRepositoryImpl  {
    private val db = FirebaseFirestore.getInstance()
    val questoesList = MutableLiveData<MutableList<Questao>>()

     fun getQuestoes(questoes: MutableLiveData<MutableList<Questao>>) {
        db.collection("Quiz").document("QcccJylpm0rwvyH2PRzZ")
            .collection("Questoes").get().addOnCompleteListener {

                if(it.isSuccessful){

                    questoes.value = it.result.toObjects(Questao::class.java)

                    //onLoad(it.result.toObjects(Questao::class.java))
                    }
                }
//                Log.d("Lulutag", "Is empty: ${it.isEmpty}")
//                Log.d("Lulutag", "Is null: ${it == null}")
//                if (!it.isEmpty && it != null) {
//
//                    for (snapshot in it) run {
//                        //  Log.d("Lulutag", "snp: ${snapshot.toObject(Questao::class.java)}")
//
//                        val questao: Questao = snapshot.toObject(Questao::class.java)
//                        questoesList.value!!.add(questao)
//                        //  Log.d("Lulutag", "Lista: ${questoesList}")
//
//                    }
//                }
            .addOnFailureListener {
                Log.d("Lulutag", "Erro: ${it.message}")
            }
      //  Log.d("Lulutag", "Lista: ${questoesList}")

    }
}

public interface OnQuestionLoad{
    fun onLoad(questoesLista: MutableList<Questao>)
    fun onError(e: Exception)
}

