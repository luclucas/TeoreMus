package com.lulu.teoremus.view.quiz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

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
private fun Tela(viewModel: QuizViewModel, lifecycleOwner: LifecycleOwner) {
    viewModel.getQuestoes()
    val context = LocalContext.current
    var opcaoA = viewModel.opcaoA
    var opcaoB = viewModel.opcaoB
    var opcaoC = viewModel.opcaoC
    var opcaoD = viewModel.opcaoD
    var resposta = viewModel.resposta
    var cont = remember{ mutableStateOf(1) }

    var imagem = viewModel.imagem
    var questao = viewModel.questao


    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.cor_botoes_modulo))
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextoQuestao("${cont.value} / 10")

        TextoQuestao(questao)

        if (!imagem.isNullOrEmpty()) {
            AsyncImage(model = imagem, contentDescription = "", imageLoader = ImageLoader(context),
                Modifier
                    .padding(30.dp)
                    .size(200.dp))
        }


        CaixaAlternativa(texto = opcaoA, onClick = {
            viewModel.incrementarCont()
            cont.value++
            conferirResposta(opcaoA!!, resposta!!, viewModel)
           // viewModel.getQuestoes()
        })



        CaixaAlternativa(texto = opcaoB, onClick = {
            viewModel.incrementarCont()
            conferirResposta(opcaoB!!, resposta!!, viewModel)
            cont.value++
            // viewModel.getQuestoes()
        })

        CaixaAlternativa(texto = opcaoC,
            onClick = {
                viewModel.incrementarCont()
                cont.value++
                conferirResposta(opcaoC!!, resposta!!, viewModel)
                //  viewModel.getQuestoes()
            })

        CaixaAlternativa(texto = opcaoD,
            onClick = {
                viewModel.incrementarCont()
                cont.value++
                conferirResposta(opcaoD!!, resposta!!, viewModel)
                //viewModel.getQuestoes()
            })


    }
}
private fun conferirResposta(opcao: String, resposta: String, viewModel: QuizViewModel){
    if (opcao.equals(resposta)){
        viewModel.incrementarQuestoesCorretas()
        Log.d("lulutag", "${viewModel.questoesCorretas.value}")
    }
}
