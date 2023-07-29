package com.lulu.teoremus.view.moduloii.graus

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloii.ModuloII

class Graus : ComponentActivity() {
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
        Titulo(titulo = "Graus")

        Texto(texto = "Os graus são nomes dados às notas que formam a escala. São numerados por números romanos. Abaixo estão os graus na escala de dó maior, porém os mesmos servem para qualquer tom das escalas diatônicas.")


        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_graus),
            contentDescription = "escala c"
        )

        Texto(texto = "Cada grau também recebe um nome, conforme a função que exerce. São eles, respectivamente: ")

        Texto(texto = "Tônica\n\nSupertônica\n\nMediante\n\nSubdominante\n\nDominante\n\nSuperdominante\n\nSensível ou subtônica")

        Texto(texto = "Os graus mais importantes são o primeiro (tônica), o quarto (subdominante) e o quinto (dominante).\n\nO sétimo grau é sensível se está meio tom abaixo da tônica. Se estiver um tom, é chamado de subtônica.")
        
        
        Subtitulo(titulo = "Graus Modais")

        Texto(texto = "Caracterizam uma escala como maior ou menor, são eles: III, IV e VII.")
        Texto(texto = "O grau III sempre irá diferir. Se ele é maior, a escala será maior, senão, menor. Já os graus IV e  VII podem ou não diferir.")

        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, ModuloII::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity?.startActivity(i)
            activity?.finish()

        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }

    }
}
