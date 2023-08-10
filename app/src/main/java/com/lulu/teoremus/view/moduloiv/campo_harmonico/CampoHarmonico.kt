package com.lulu.teoremus.view.moduloiv.campo_harmonico

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.Tabela
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.Imagem

class CampoHarmonico : ComponentActivity() {
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
    val colunasGraus = 2
    val titulosGraus = listOf("Grau", "Tipo")
    val dataGraus = listOf(
        listOf("I", "Maior"),
        listOf("II", "Menor"),
        listOf("III", "Menor"),
        listOf("IV", "Maior"),
        listOf("V", "Maior"),
        listOf("VI", "Menor"),
        listOf("VII", "Meio-Diminuto"),
    )

    val dataGrausTetrade = listOf(
        listOf("I", "Maior 7M"),
        listOf("II", "Menor 7"),
        listOf("III", "Menor 7"),
        listOf("IV", "Maior 7M"),
        listOf("V", "Maior 7"),
        listOf("VI", "Menor 7"),
        listOf("VII", "Meio-Diminuto 7"),
    )


    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Titulo(titulo = "Campo harmônico")
        Texto(texto = "O campo harmônico consiste no conjunto de acordes que podem ser formados a partir de uma escala.")

        Texto(texto = "Para formar um campo harmônico, basta utilizar as fórmulas dadas nas aulas de tríades, tétrades e formação de acordes. Por exemplo, pegando a escala maior natural, temos os seguintes acordes:")

        Tabela(titulos = titulosGraus, data = dataGraus, columns = colunasGraus)

        Texto(texto = "Para as tétrades, temos:")

        Tabela(titulos = titulosGraus, data = dataGrausTetrade, columns = 2)



        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, CampoHarmonico2::class.java)
                activity?.startActivity(i)
            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Avançar", color = Color.White, fontSize = 20.sp)
        }

    }
}
