package com.lulu.teoremus.view.moduloii

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.view.moduloii.escalas.Escalas
import com.lulu.teoremus.view.moduloii.graus.Graus
import com.lulu.teoremus.view.moduloii.intervalos.Intervalos
import com.lulu.teoremus.view.moduloii.tom_tonalidade.TomTonalidade

val listaNomes = listOf(
    "Intervalo", "Escalas", "Graus", "Tom x Tonalidade"
)


val listaActivity = listOf(
    Intervalos::class.java,
    Escalas::class.java,
    Graus::class.java,
    TomTonalidade::class.java

    )

class ModuloII : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriarBotoes()
        }
    }
}

@Composable
private fun CriarBotoes() {
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Row() {
                BotoesAula(nome = listaNomes[0], 0)
                BotoesAula(nome = listaNomes[1], 1)
            }
        Row() {
            BotoesAula(nome = listaNomes[2], 2)
            BotoesAula(nome = listaNomes[3], 3)
        }
     //   BotoesAula(nome = listaNomes.last(), listaNomes.lastIndex)
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
        Text(
            text = nome,
            fontSize = 15.sp,
            color = colorResource(id = R.color.texto_botao_mod),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun BotaoQuiz() {
    Button(
        onClick = {}, modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(20.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.card_tela_principal))
    ) {
        Text(text = "Quiz", fontSize = 30.sp, color = colorResource(id = R.color.texto_botao_quiz))
    }
}