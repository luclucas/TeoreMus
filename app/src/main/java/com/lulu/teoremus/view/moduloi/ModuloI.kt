package com.lulu.teoremus.view.moduloi

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.view.moduloi.inicio.InicioI

val listaNomes = listOf(
    "Início", "Notas", "Pauta", "Clave de Sol",
    "Clave de Fá", "Durações"
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
private fun CriarBotoes(){
        Column(
            Modifier
                .padding(20.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            for(i in listaNomes.indices step 2){
                var isRow = true
                if (isRow) {
                    Row() {
                        BotoesAula(nome = listaNomes[i])
                        BotoesAula(nome = listaNomes[i + 1])
                        isRow = false
                    }
                }
        }
            BotaoQuiz()
    }
}

@Composable
private fun BotoesAula(nome: String) {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(context, InicioI::class.java))
    },
        Modifier
            .padding(10.dp)
            .size(130.dp)
            , colors = ButtonDefaults.buttonColors(colorResource(id = R.color.cor_botoes_modulo))) {
        Text(text = nome, fontSize = 18.sp, color = colorResource(id = R.color.texto_botao_mod))
    }
}

@Composable
private fun BotaoQuiz() {
    Button(onClick = {}, modifier = Modifier
        .height(120.dp)
        .fillMaxWidth()
        .padding(20.dp),
    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.card_tela_principal))) {
        Text(text = "Quiz", fontSize = 30.sp, color = colorResource(id = R.color.texto_botao_quiz))
    }
}