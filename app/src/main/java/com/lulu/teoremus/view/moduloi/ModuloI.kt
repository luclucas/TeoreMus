package com.lulu.teoremus.view.moduloi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.lulu.teoremus.utils.MODULO_I
import com.lulu.teoremus.view.moduloi.clave_sol.ClaveSol
import com.lulu.teoremus.view.moduloi.inicio.InicioI
import com.lulu.teoremus.view.moduloi.notas.NotasActivity
import com.lulu.teoremus.view.moduloi.pauta.Pauta
import com.lulu.teoremus.view.moduloi.qualidades.QualidadesDoSom
import com.lulu.teoremus.view.moduloi.tom.Tom
import com.lulu.teoremus.view.quiz.Quiz

val listaNomes = listOf(
    "A música", "O som", "Notas", "Pauta", "Clave de sol",
    "Semitom e tom",
    //"Durações"
)


val listaActivity = listOf(
    InicioI::class.java,
    QualidadesDoSom::class.java,
    NotasActivity::class.java,
    Pauta::class.java,
    ClaveSol::class.java,
    Tom::class.java
)

class ModuloI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriarBotoes()
        }
    }
}

@Composable
private fun CriarBotoes() {
    val context = LocalContext.current as Activity
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.padding(10.dp).fillMaxWidth().fillMaxHeight(0.1f), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.ArrowBack,

                contentDescription = "",
                tint = colorResource(
                    id = R.color.card_tela_principal
                ),
                modifier = Modifier.padding(end = 20.dp).size(40.dp).clickable {
                    context.finish()
                }
            )
            androidx.compose.material3.Text(
                text = "Módulo I",
                style = Typography.h1,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.card_tela_principal)
            )
        }

        for (i in listaNomes.indices step 2) {
                Row{
                    BotoesAula(nome = listaNomes[i], i)
                    BotoesAula(nome = listaNomes[i + 1], i + 1)
            }
        }
        BotaoQuiz()
    }
}

@Composable
private fun BotoesAula(nome: String, i: Int) {
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
        Text(text = nome, fontSize = 18.sp, color = colorResource(id = R.color.texto_botao_mod), textAlign = TextAlign.Center)
    }
}

@Composable
private fun BotaoQuiz() {
    val context = LocalContext.current
    Button(
        onClick = {
            val i = Intent(context, Quiz::class.java).apply {
                putExtra("document", MODULO_I)
                putExtra("modulo", "moduloI")
            }
                  context.startActivity(i)
        },
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(20.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.card_tela_principal))
    ) {
        Text(text = "Quiz", fontSize = 30.sp, color = colorResource(id = R.color.texto_botao_quiz))
    }
}