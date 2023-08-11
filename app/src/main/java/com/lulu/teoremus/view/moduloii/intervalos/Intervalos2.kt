package com.lulu.teoremus.view.moduloii.intervalos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import com.lulu.teoremus.utils.Tabela
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.Imagem

class Intervalos2 : ComponentActivity() {
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

    val intervaloTitles = listOf("Intervalo", "Quantidade de notas")
    val colunas = 2
    val intervaloSimplesData = listOf(
        listOf("Primeira (1ª)", "Uma nota"),
        listOf("Segunda (2ª)", "Duas notas"),
        listOf("Terça (3ª)", "Três notas"),
        listOf("Quarta (4ª)", "Quatro notas"),
        listOf("Quinta (5ª)", "Cinco notas"),
        listOf("Sexta (6ª)", "Seis notas"),
        listOf("Sétima (7ª)", "Sete notas"),
        listOf("Oitava (8ª)", "Oito notas"),
    )
    val intervaloCompostoData = listOf(
        listOf("Nona (9ª)", "Nove notas"),
        listOf("Décima (10ª)", "Dez notas"),
        listOf("Décima-primeira (11ª)", "Onze notas"),
        listOf("Décima-segunda (12ª)", "Doze notas"),
    )


    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Classificação dos Intervalos")

        Texto(texto = "A classificação dos intervalos pode se dar por duas maneiras, sendo elas:\n\na) Numericamente\n\nb) Qualitativamente")

        Subtitulo(titulo = "Numericamente")

        Texto(texto = "É feita segundo o número de notas contidas no intervalo, inclusive são contadas as notas que formam o intervalo. É feito da seguinte maneira:")
        Subtitulo("Intervalo simples:")

        Tabela(titulos = intervaloTitles, data = intervaloSimplesData, columns =colunas )

//        Texto(texto = "primeira    (1ª)    uma nota")
//        Texto(texto = "segunda    (2ª)    duas notas")
//        Texto(texto = "terça    (3ª)    três notas")
//        Texto(texto = "quarta    (4ª)    quatro notas")
//        Texto(texto = "quinta    (5ª)    cinco notas")
//        Texto(texto = "sexta    (6ª)    seis notas")
//        Texto(texto = "sétima    (7ª)    sete notas")
//        Texto(texto = "oitava    (8ª)    oito notas")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_int_num_um)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_int_num_um),
            contentDescription = "Clave"
        )

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_int_num_dois)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_int_num_dois),
            contentDescription = "Clave"
        )


//        Image(
//            modifier = Modifier
//                .padding(top = 30.dp)
//                .fillMaxWidth()
//                .size(120.dp),
//            alignment = Alignment.Center,
//            painter = painterResource(id = R.drawable.img_int_num_um),
//            contentDescription = "intervalo numerico"
//        )
//
//        Image(
//            modifier = Modifier
//                .padding(top = 30.dp)
//                .fillMaxWidth()
//                .size(120.dp),
//            alignment = Alignment.Center,
//            painter = painterResource(id = R.drawable.img_int_num_dois),
//            contentDescription = "intervalo num"
//        )

        Subtitulo(titulo = "Intervalo composto")


        Tabela(titulos = intervaloTitles, data = intervaloCompostoData, columns =colunas )

//        Texto(texto = "nona    (9ª)    nove notas")
//        Texto(texto = "décima    (10ª)    dez notas")
//        Texto(texto = "décima primeira   (11ª)    onze notas")
//        Texto(texto = "décima segunda  (12ª)    doze notas")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_int_num_tres)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_int_num_tres),
            contentDescription = "Clave"
        )

        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, Intervalos3::class.java)
                activity?.startActivity(i)


            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Avançar", color = Color.White, fontSize = 20.sp)
        }
    }
}