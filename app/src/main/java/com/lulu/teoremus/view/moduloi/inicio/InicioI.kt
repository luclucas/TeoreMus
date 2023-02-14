package com.lulu.teoremus.view.moduloi.inicio

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lulu.teoremus.R
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.model.*

val midia = Midia()


class InicioI : ComponentActivity() {
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
        horizontalAlignment = Alignment.CenterHorizontally)
     {
        Titulo(titulo = "Início")
        Texto(texto = stringResource(id = R.string.inicio1))
        Subtitulo(titulo = "Melodia")
        Texto(texto = stringResource(id = R.string.inicio_melodia))
        Texto(texto = "Na imagem abaixo, você vê um trecho da música \"La vie en rose\", um exemplo de melodia.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_la_vie),
            contentDescription = "la vie"
        )

        Texto(texto = "Tocando no botão abaixo, você ouvirá a melodia da música:")

        BotaoAudio(
            texto = "Toque-me",
            midia,
            escolha = Escolhas.MELODIA_LA_VIE,
            context
        )

         CaixaDesafio("Preste mais atenção nas melodias das músicas que você ouve. Quais as diferenças entre elas?")
    }

}
