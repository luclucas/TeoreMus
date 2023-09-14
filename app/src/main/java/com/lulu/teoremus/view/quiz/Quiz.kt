package com.lulu.teoremus.view.quiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import coil.compose.AsyncImage
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
            Tela(quizViewModel)
        }
    }

    override fun onStart() {
        super.onStart()
        quizViewModel.questoes.observe(
            this
        ) {
            quizViewModel.getQuestoes()
        }

        quizViewModel.cont.observe(
            this
        ){
            quizViewModel.getQuestoes()

        }
    }
}


//@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun Tela(viewModel: QuizViewModel ) {
    viewModel.getQuestoes()
    val context = LocalContext.current as Activity
    val opcaoA = viewModel.opcaoA
    val opcaoB = viewModel.opcaoB
    val opcaoC = viewModel.opcaoC
    val opcaoD = viewModel.opcaoD
    val resposta = viewModel.resposta
    val cont = remember{ mutableStateOf(1) }

    val textoCont = remember{
        mutableStateOf(cont.value.toString())
    }

    val imagem = viewModel.imagem
    val questao = viewModel.questao

    if (cont.value > 10) {
        val i = Intent(context, ResultadoQuiz::class.java).apply{
            putExtra("questoes_corretas", viewModel.questoesCorretas.value)
            putExtra("lista_categorias", ArrayList(viewModel.categoriaQuestoes))
        }
        context.startActivity(i)
        context.finish()
    }


    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.cor_botoes_modulo))
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextoQuestao("${textoCont.value} / 10")

        TextoQuestao(questao)

        if (!imagem.isNullOrEmpty()) {
            AsyncImage(model = imagem, contentDescription = "", imageLoader = ImageLoader(context),
                Modifier
                    .padding(30.dp)
                    .size(200.dp))
        }


        CaixaAlternativa(texto = opcaoA, onClick = {
            viewModel.incrementarCont()
            viewModel.conferirResposta(opcaoA!!, resposta!!)
            cont.value++
            if(cont.value <= 10) {
                textoCont.value = cont.value.toString()
            }
        })



        CaixaAlternativa(texto = opcaoB, onClick = {
            viewModel.incrementarCont()
            viewModel.conferirResposta(opcaoB!!,resposta!!)
            cont.value++
            if(cont.value <= 10) {
                textoCont.value = cont.value.toString()
            }

        })

        CaixaAlternativa(texto = opcaoC,
            onClick = {
                viewModel.incrementarCont()
                viewModel.conferirResposta(opcaoC!!, resposta!!)
                cont.value++
                if(cont.value <= 10) {
                    textoCont.value = cont.value.toString()
                }
            })

        CaixaAlternativa(texto = opcaoD,
            onClick = {
                viewModel.incrementarCont()
                viewModel.conferirResposta(opcaoD!!, resposta!!)
                cont.value++
                if(cont.value <= 10) {
                    textoCont.value = cont.value.toString()
                }
            })


    }
}

