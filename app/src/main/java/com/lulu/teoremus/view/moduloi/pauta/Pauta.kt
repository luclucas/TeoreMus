package com.lulu.teoremus.view.moduloi.pauta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo

class Pauta : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Pauta Musical")

        Texto(texto = "A pauta ou pentagrama consiste em cinco linhas e quatro espaços onde serão escritas as notas musicais.")

        Texto(texto = "Na pauta, as linhas são contadas de baixo para cima e as notas mais graves ficam nas linhas inferiores e as notas mais agudas nas linhas superiores")

        Texto("Na imagem abaixo, você vê um exemplo da pauta ")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_pauta),
            contentDescription = "pauta"
        )

        Subtitulo(titulo = "Linhas suplementares")
        
        Texto(texto = "Caso queira adicionar notas que não estão nas 5 linhas normais da pauta, é possível adicionar novas linhas. Conforme a imagem abaixo: ")

        Image(
            modifier = Modifier

                .fillMaxWidth()
                .size(400.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_linhas_sup),
            contentDescription = "pauta"
        )
    }
}