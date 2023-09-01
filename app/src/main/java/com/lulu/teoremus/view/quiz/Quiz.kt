package com.lulu.teoremus.view.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.lulu.teoremus.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Quiz : ComponentActivity() {
    private lateinit var quizViewModel: QuizViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]
        quizViewModel.getQuestoes()
        //   quizViewModel.showQuestions()

        setContent {
            Tela(quizViewModel, this)
        }
    }

    override fun onStart() {
        super.onStart()
        val lifecycleOwner = this
        quizViewModel.questoes.observe(
            lifecycleOwner
        ) {
            quizViewModel.getQuestoes()
        }
    }
}


@Composable
private fun Tela(viewModel: QuizViewModel, lifecycleOwner: LifecycleOwner) {
    viewModel.getQuestoes()

    var questao = viewModel.questao
    var alternativaA = viewModel.alternativaA
    var alternativaB = viewModel.alternativaB
    var alternativaC = viewModel.alternativaC
    var alternativaD = viewModel.alternativaD


    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.cor_botoes_modulo))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "1 / 10", color = Color.White)

        TextoQuestao(questao)
        CaixaAlternativa(texto = alternativaA)
        CaixaAlternativa(texto = alternativaB)

        CaixaAlternativa(texto = alternativaC)

        CaixaAlternativa(texto = alternativaD)


    }

}