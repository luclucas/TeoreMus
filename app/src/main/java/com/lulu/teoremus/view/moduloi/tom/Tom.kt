package com.lulu.teoremus.view.moduloi.tom

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
import com.lulu.teoremus.utils.Tabela
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloi.ModuloI

class Tom : ComponentActivity() {
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

    val dataNotas = listOf(
        listOf("C"),
        listOf("C# ou Db"),
        listOf("D"),
        listOf("D# ou Eb"),
        listOf("E"),
        listOf("F"),
        listOf("F# ou Gb"),
        listOf("G"),
        listOf("G# ou Ab"),
        listOf("A"),
        listOf("A# ou Bb"),
        listOf("B"),
    )
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Semitom e Tom")

        Subtitulo(titulo = "Semitom")

        Texto(texto = "O semitom ou meio tom é o menor intervalo entre duas notas.")

        Subtitulo(titulo = "Tom")

        Texto(texto = "Já o tom é a soma de dois semitons.")

        Subtitulo(titulo = "Acidentes")
        Texto(texto = "Os acidentes são sinais que alteram as notas, os mais comuns são:")
        Texto(texto = "Sustenido(#): faz com que a nota suba um tom")
        Texto(texto = "Bemol(♭): faz com que a nota abaixe meio tom")
        
        Texto(texto = "Com os acidentes, obtemos o total de doze notas, sendo elas:")

        Tabela(titulos = listOf("Notas"), data = dataNotas, columns = 1)
//
//        Texto(texto = "C\nC# | D♭\nD\nD# | E♭\nE\nF\nF# | G♭\nG\nG# | A♭\nA\nA# | B♭\nB\nC")

        Texto(texto = "A distância entre notas vizinhas é de meio tom, por exemplo, Dó (C) e Dó sustenido (C#). A distância entre Dó e Ré (D) é de um tom")

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