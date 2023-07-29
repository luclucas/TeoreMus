package com.lulu.teoremus.view.moduloi.qualidades

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
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.utils.CaixaDesafio
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloi.ModuloI

class QualidadesDoSom : ComponentActivity() {
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


        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, ModuloI::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                activity?.startActivity(i)
                activity?.finish()

            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }


}
