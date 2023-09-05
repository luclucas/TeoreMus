package com.lulu.teoremus.view.quiz

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lulu.teoremus.data.QuestoesRepositoryImpl
import com.lulu.teoremus.model.Questao

class QuizViewModel : ViewModel() {

    val questoes = MutableLiveData<MutableList<Questao>>()
    val cont = MutableLiveData<Int>(0)

    val questoesCorretas = MutableLiveData<Int>(0)

    var questao by mutableStateOf<String?>(" ")
    var resposta by mutableStateOf<String?>("")
    var categoria by mutableStateOf<String?>("")

    var opcaoA by mutableStateOf<String?>("")
    var opcaoB by mutableStateOf<String?>("")
    var opcaoC by mutableStateOf<String?>("")
    var opcaoD by mutableStateOf<String?>("")
    var imagem by mutableStateOf<String?>("")


    init {
        QuestoesRepositoryImpl().getQuestoes(questoes)

    }

    fun getQuestoes() {
     //   Log.d("lulutag", questoes.value.toString())
        if (!questoes.value.isNullOrEmpty()) {
            questao = questoes.value!![cont.value!!].questao
            resposta = questoes.value!![cont.value!!].resposta
            opcaoA = questoes.value!![cont.value!!].opcao_a
            opcaoB = questoes.value!![cont.value!!].opcao_b
            opcaoC = questoes.value!![cont.value!!].opcao_c
            opcaoD = questoes.value!![cont.value!!].opcao_d
            categoria = questoes.value!![cont.value!!].categoria
            imagem = questoes.value!![cont.value!!].imagem
        }
    }

    fun incrementarCont() {
        val a = cont.value!! + 1
        cont.value = a
    }

    fun incrementarQuestoesCorretas(){
        val a = questoesCorretas.value!! + 1
        questoesCorretas.value = a
    }
}