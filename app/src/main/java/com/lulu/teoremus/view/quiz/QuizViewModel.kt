package com.lulu.teoremus.view.quiz

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lulu.teoremus.data.QuestoesRepositoryImpl
import com.lulu.teoremus.model.Questao
import kotlin.random.Random
import kotlin.random.nextInt

class QuizViewModel : ViewModel() {

    val questoes = MutableLiveData<MutableList<Questao>>()
    private val cont = MutableLiveData(0)

    var questao by mutableStateOf<String?>(" ")
    val resposta = MutableLiveData("")
    val opcaoA by mutableStateOf<String?>("")
    val opcaoB by mutableStateOf<String?>("")
    val opcaoC by mutableStateOf<String?>("")
    val opcaoD by mutableStateOf<String?>("")
    val imagem = MutableLiveData("")

    var alternativaA by mutableStateOf<String?>("")
    var alternativaB by mutableStateOf<String?>("")
    var alternativaC by mutableStateOf<String?>("")
    var alternativaD by mutableStateOf<String?>("")

    init {
        QuestoesRepositoryImpl().getQuestoes(questoes)
        getQuestoes()
    }

    fun getQuestoes() {
        Log.d("lulutag", questoes.value.toString())
        if (!questoes.value.isNullOrEmpty()) {
            questao = questoes.value!![cont.value!!].questao
            resposta.value = questoes.value!![cont.value!!].resposta
            embaralharOpcoes()
            imagem.value = questoes.value!![cont.value!!].imagem
        }
    }

    private fun embaralharOpcoes() {
        val lista = mutableListOf<Int>()
        val listaQuestoes = mutableListOf<String?>()
        while (lista.size < 4) {
            val i = Random.nextInt(0..3)
            if (!lista.contains(i)) {
                lista.add(i)
            }
        }

        for (i in 0 until 4) {
            when (lista[i]) {
                0 -> listaQuestoes.add(questoes.value!![cont.value!!].opcao_a)
                1 -> listaQuestoes.add(questoes.value!![cont.value!!].opcao_b)
                2 -> listaQuestoes.add(questoes.value!![cont.value!!].opcao_c)
                3 -> listaQuestoes.add(questoes.value!![cont.value!!].resposta)
            }
        }

        alternativaA = listaQuestoes[0]
        alternativaB = listaQuestoes[1]
        alternativaC = listaQuestoes[2]
        alternativaD = listaQuestoes[3]
    }
}