package com.lulu.teoremus.view.moduloiii.triades

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloiii.ModuloIII
import com.lulu.teoremus.view.moduloiii.triades.ui.theme.TeoreMusTheme

class Triades : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Tríades")

        Texto(texto = "Na aula anterior vimos as notas naturais, formadas pela tônica, terça e quinta. Esses acordes são chamados de tríades, formados por duas terças consecutivas. Veremos como elas são classificadas.")

        Subtitulo(titulo = "Maior")
        Texto(texto = "Formados por: 1ª - 3ª maior - 5ª justa")

        Subtitulo(titulo = "Menor")
        Texto(texto = "Formados por: 1ª - 3ª menor - 5ª justa")


        Subtitulo(titulo = "Suspenso")
        Texto(texto = "Formados por: 1ª - 2ª ou 4ª - 5ª justa")


        Subtitulo(titulo = "Aumentada")
        Texto(texto = "Formados por: 1ª - 3ª maior - 5ª aumentada")


        Subtitulo(titulo = "Diminuto")
        Texto(texto = "Formados por: 1ª - 3ª menor - 5ª diminuta")

        Subtitulo(titulo = "Campo harmônico")
        Texto(texto = "Num campo harmônico de uma escala maior natural, teremos os seguintes acordes:")
        Texto(texto = "I maior\nII menor\nIII menor\nIV maior\nV maior\nVI menor\nVII diminuto")

        Texto(texto = "Na escada de C maior, temos os acordes: C Dm Em F G Am Bm(b5)")

        Texto(texto = "Lembrando que acorde e notas são diferentes, acorde é o conjunto de notas distintas.")

        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, ModuloIII::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                activity?.startActivity(i)
                activity?.finish()

            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            androidx.compose.material.Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }
}

