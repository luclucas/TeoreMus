package com.lulu.teoremus.view.moduloiv.formacao_acordes

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
import com.lulu.teoremus.view.moduloiv.ModuloIV

class FormacaoAcordes2 : ComponentActivity() {
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

        Titulo(titulo = "Lista dos acordes")

        Texto(texto = "Abaixo teremos a lista dos acordes maiores e menores. As notas que estão entre parênteses são a sétima maior e a sétima menor, respectivamente. Nos acordes menores, utilizaremos apenas a sétima menor, pois estamos seguindo a escala maior natural.")

        Subtitulo(titulo = "Maiores")

        Texto(texto = "Dó - C E G (B ou Bb)\nRé - D F# A (C# ou C)\nMi - E G# B (D# ou D)\nFá - F A C (E ou Eb)\nSol - G B D (F# ou F)\nLá - A C# E (G# ou G)\nSi - B D# F# (A# ou A)")

        Subtitulo(titulo = "Menores")

        Texto(texto = "Dó - C Eb G (Bb)\nRé - D F A (C)\nMi - E G B (D)\nFá - F Ab C (Eb)\nSol - G Bb D (F)\nLá - A C E (G)\nSi - B D F# (A)")


        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, ModuloIV::class.java)
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