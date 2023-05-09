package com.lulu.teoremus.view.moduloii.intervalos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.ferramentas.Subtitulo
import com.lulu.teoremus.ferramentas.Texto
import com.lulu.teoremus.ferramentas.Titulo
import com.lulu.teoremus.view.moduloii.intervalos.ui.theme.TeoreMusTheme

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
        Texto(texto = "Intervalo simples:")

        Texto(texto = "primeira    (1ª)    uma nota")
        Texto(texto = "segunda    (2ª)    duas notas")
        Texto(texto = "terça    (3ª)    três notas")
        Texto(texto = "quarta    (4ª)    quatro notas")
        Texto(texto = "quinta    (5ª)    cinco notas")
        Texto(texto = "sexta    (6ª)    seis notas")
        Texto(texto = "sétima    (7ª)    sete notas")
        Texto(texto = "oitava    (8ª)    oito notas")


        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_int_num_um),
            contentDescription = "intervalo numerico"
        )

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_int_num_dois),
            contentDescription = "intervalo num"
        )

        Texto(texto = "Intervalo composto:")

        Texto(texto = "nona    (9ª)    nove notas")
        Texto(texto = "décima    (10ª)    dez notas")
        Texto(texto = "décima primeira   (11ª)    onze notas")
        Texto(texto = "décima segunda  (12ª)    doze notas")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_int_num_tres),
            contentDescription = "intervalo num"
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