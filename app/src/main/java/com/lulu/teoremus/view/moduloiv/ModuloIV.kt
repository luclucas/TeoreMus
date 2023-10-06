package com.lulu.teoremus.view.moduloiv

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.fontes.Typography
import com.lulu.teoremus.utils.MODULO_IV
import com.lulu.teoremus.view.moduloiv.campo_harmonico.CampoHarmonico
import com.lulu.teoremus.view.moduloiv.ciclo_quartas.CicloQuartas
import com.lulu.teoremus.view.moduloiv.ciclo_quintas.CicloQuintas
import com.lulu.teoremus.view.moduloiv.formacao_acordes.FormacaoAcordes
import com.lulu.teoremus.view.quiz.Quiz

class ModuloIV : ComponentActivity() {

    private val listaNomes = listOf(
        "Formação de acordes", "Campo harmônico", "Ciclo das quintas", "Ciclo das quartas"
    )


    private val listaActivity = listOf(
        FormacaoAcordes::class.java,
        CampoHarmonico::class.java,
        CicloQuintas::class.java,
        CicloQuartas::class.java

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriarBotoes(listaNomes, listaActivity)
        }
    }
}

@Composable
private fun CriarBotoes(
    listaNomes: List<String>,
    listaActivity: List<Class<out ComponentActivity>>
) {

    val context = LocalContext.current as Activity

    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,

                contentDescription = "",
                tint = colorResource(
                    id = R.color.card_tela_principal
                ),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(40.dp)
                    .clickable {
                        context.finish()
                    }
            )
            androidx.compose.material3.Text(
                text = "Módulo IV",
                style = Typography.h1,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.card_tela_principal)
            )
        }
        Row {
            BotoesAula(nome = listaNomes[0], 0, listaActivity)
            BotoesAula(nome = listaNomes[1], 1, listaActivity)
        }
        Row {
            BotoesAula(nome = listaNomes[2], 2, listaActivity)
            BotoesAula(nome = listaNomes[3], 3, listaActivity)
        }
        //   BotoesAula(nome = listaNomes.last(), listaNomes.lastIndex)
        BotaoQuiz()
    }
}

@Composable
private fun BotoesAula(nome: String, i: Int, listaActivity: List<Class<out ComponentActivity>>) {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(Intent(context, listaActivity[i]))

        },
        Modifier
            .padding(10.dp)
            .size(130.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.cor_botoes_modulo))
    ) {
        Text(
            text = nome,
            fontSize = 16.sp,
            color = colorResource(id = R.color.texto_botao_mod),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun BotaoQuiz() {
    val context = LocalContext.current
    Button(
        onClick = {
            val i = Intent(context, Quiz::class.java).apply {
                putExtra("document", MODULO_IV)
                putExtra("modulo", "moduloIV")
            }
            context.startActivity(i)
        }, modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(20.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.card_tela_principal))
    ) {
        Text(text = "Quiz", fontSize = 30.sp, color = colorResource(id = R.color.texto_botao_quiz))
    }
}

