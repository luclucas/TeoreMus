package com.lulu.teoremus.view.moduloi.qualidades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lulu.teoremus.ferramentas.CaixaDesafio
import com.lulu.teoremus.ferramentas.Subtitulo
import com.lulu.teoremus.ferramentas.Texto
import com.lulu.teoremus.ferramentas.Titulo
import com.lulu.teoremus.view.moduloi.qualidades.ui.theme.TeoreMusTheme

class QualidadesDoSom : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela(){
    Column(        modifier = Modifier
        .padding(20.dp)
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

    Titulo(titulo = "Características do Som")
    Texto(texto = "As principais características do som são: altura, duração, intensidade e timbre.\n Vamos ver cada uma delas.")

    Subtitulo(titulo = "Altura")
    Texto(texto = "A altura determina se o som é grave ou agudo, por exemplo, a nota dó pode ser tocada em uma região mais grave ou aguda. Muito cuidado para não confundir com o volume do som.")

    Subtitulo(titulo = "Duração")
    Texto(texto = "Como o prório nome já sugere, a duração é o tempo em que o som soa.")

    Subtitulo(titulo = "Intensidade")
    Texto(texto = "A intensidade é o volume sonoro. Muitas músicas utilizam desse artifício, tocando trechos com intensidades diferentes")

    Subtitulo(titulo = "Timbre")
    Texto(texto = "O timbre é a característica de cada som. Diferentes instrumentos podem tocar a mesma nota, porém cada um manterá suas diferenças")

    CaixaDesafio(texto = "Comece a reparar nos sons ao seu redor, os diferentes tipos de barulhos e timbres. Também repare em como as músicas trabalha com as características do som")
    }
}
