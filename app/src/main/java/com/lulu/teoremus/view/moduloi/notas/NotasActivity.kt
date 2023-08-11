package com.lulu.teoremus.view.moduloi.notas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.utils.CaixaParaOuvir
import com.lulu.teoremus.utils.Midias
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Tabela
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.Imagem
import com.lulu.teoremus.view.moduloi.ModuloI

class NotasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela() {
    val midia = Midias()
    val context = LocalContext.current

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
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Titulo(titulo = "Notas")
        Texto(texto = "Uma nota musical se dá pela frequência do som, podendo haver a mesma nota em diferentes alturas, ou seja, uma mesma nota pode ser tocada de uma forma aguda ou grave.")

        Subtitulo(titulo = "As notas musicais")

        Texto(texto = "No sistema ocidental, existem 7 notas musicais, abaixo estão os seus nomes e letras utilizadas para representá-las:")

        Tabela(titulos = titulosNotas, data = dataNotas, columns = columnsNotas)

//        Texto(texto ="Dó - C\n" +
//                "Ré - D\n" +
//                "Mi -  E\n" +
//                "Fá -  F\n" +
//                "Sol - G\n" +
//                "Lá -  A\n" +
//                "Si -   B")

        Texto(texto = "A nota \"Si\" também é representada como H na notação alemã")

        Subtitulo(titulo = "Partitura")

        Texto(texto = "Outra maneira de representar as notas é por meio das partituras\n" +
                "Na imagem abaixo, você pode ver um exemplo de como elas são escritas: ")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_escala_c_i)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_escala_c_i),
            contentDescription = "Clave"
        )

//        Image(
//            modifier = Modifier
//                .padding(top = 30.dp)
//                .fillMaxWidth()
//                .size(100.dp),
//            alignment = Alignment.Center,
//            painter = painterResource(id = R.drawable.img_escala_c_i),
//            contentDescription = "Escala dó"
//        )

        CaixaParaOuvir(texto = "Toque no botão abaixo para ouvir a escala de dó maior", midia = midia, escolha = Escolhas.ESCALA_C, context = context)

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
            androidx.compose.material.Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }
}
