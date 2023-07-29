package com.lulu.teoremus.view.moduloiii.cifras

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloiii.ModuloIII

class Cifras : ComponentActivity() {
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
        Titulo(titulo = "Cifras")

        Texto(texto = "A cifra é um modo de representar acordes de maneira mais compacta. As notas são:")
        Texto(texto = "C - dó\nD - ré\nE - mi\nF - fá\nG - sol\nA - Lá\nB - si")

        Subtitulo(titulo = "Classificação")
        Texto(texto = "Elas podem ser classificadas em:")

        Texto("Maior: utilizam apenas as letras\nMenor: utilizam as letras + m\nMaior com sétima maior: letra + 7M\nMaior com sétima menor: letra + 7\nMenor com sétima maior: letra + m7M\nMenor com sétima menor: letra + m7\nMeio-diminuto: letra + m(b5)\nDiminuto: letra + º")

        Subtitulo(titulo = "Exemplo")
        Texto(texto = "Para o acorde de C, temos:")
        Texto(texto = "Dó maior - C\nDó menor - Cm\n" +
                "Dó maior com sétima - C7M\n" +
                "Dó maior com sétima menor- C7\n" +
                "Dó menor com sétima - Cm7M\n" +
                "Dó menor com sétima menor - Cm7\n" +
                "Dó meio-diminuto - Cm7(b5)" +
                "Dó diminuto - Cº")

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
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }
}