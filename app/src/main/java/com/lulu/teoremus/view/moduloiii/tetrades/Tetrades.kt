package com.lulu.teoremus.view.moduloiii.tetrades

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
import com.lulu.teoremus.view.moduloiii.tetrades.ui.theme.TeoreMusTheme

class Tetrades : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Tétrades")

        Texto(texto = "As tétrades são formadas por três terças consecutivas, formando um acorde com quatro sons. Elas podem ser classificadas em sete tipos básicos:")

        Subtitulo(titulo = "Sétima maior")
        Texto(texto = "Formados por: 1ª - 3ª maior - 5ª justa - 7ª maior")


        Subtitulo(titulo = "Menor com sétima")
        Texto(texto = "Formados por: 1ª - 3ª menor - 5ª justa - 7ª menor")


        Subtitulo(titulo = "Dominante")
        Texto(texto = "Formados por: 1ª - 3ª maior - 5ª justa - 7ª menor")


        Subtitulo(titulo = "Diminuta")
        Texto(texto = "Formados por: 1ª - 3ª menor - 5ª diminuta - 7ª bb")


        Subtitulo(titulo = "Menor com sétima maior")
        Texto(texto = "Formados por: 1ª - 3ª menor - 5ª justa - 7ª maior")


        Subtitulo(titulo = "Meia-diminuta")
        Texto(texto = "Formados por: 1ª - 3ª menor - 5ª diminuta - 7ª menor")


        Subtitulo(titulo = "Sétima maior e quinta aumentada")
        Texto(texto = "Formados por: 1ª - 3ª maior - 5ª aumentada - 7ª maior")

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