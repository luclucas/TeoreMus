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
import com.lulu.teoremus.utils.Tabela
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

    val columnsNotas = 2
    val titulosNotas = listOf("Nota", "Cifra")
    val dataNotas = listOf(
        listOf("Dó", "C"),
        listOf("Ré", "D"),
        listOf("Mi", "E"),
        listOf("Fá", "F"),
        listOf("Sol", "G"),
        listOf("Lá", "A"),
        listOf("Si", "B"),
        )

    val dataAcordes = listOf(
        listOf("Maior", "Letra"),
        listOf("Menor", "Letra + m"),
        listOf("Maior com sétima maior", "Letra + 7M"),
        listOf("Maior com sétima menor", "Letra + 7"),
        listOf("Menor com sétima maior", "Letra + m7M"),
        listOf("Menor com sétima menor", "Letra + m7"),
        listOf("Meior-diminuto", "Letra + m7(b5)"),
        listOf("Diminuto", "Letra + º"),
    )


    val dataExemplo = listOf(
        listOf("Dó maior", "C"),
        listOf("Dó menor", "Cm"),
        listOf("Dó maior com sétima maior", "C7M"),
        listOf("Dó maior com sétima menor", "C7"),
        listOf("Dó menor com sétima maior", "Cm7M"),
        listOf("Dó menor com sétima menor", "Cm7"),
        listOf("Dó meior-diminuto", "Cm7(b5)"),
        listOf("Dó diminuto", "Cº"),
    )

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
        Tabela(titulos = titulosNotas, data = dataNotas, columns = columnsNotas)

        Subtitulo(titulo = "Classificação")
        Texto(texto = "Elas podem ser classificadas em:")
        Tabela(titulos = titulosNotas, data = dataAcordes, columns = columnsNotas)


        Subtitulo(titulo = "Exemplo")
        Texto(texto = "Para o acorde de C, temos:")
        Tabela(titulos = titulosNotas, data = dataExemplo, columns = columnsNotas)

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