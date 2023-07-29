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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo

class Intervalos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Preview(showSystemUi = true)
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
        Titulo(titulo = "Intervalo")
        Texto(texto = "O intervalo é a diferença de altura entre duas notas. A sua medida se dá por tons e semitons, por exemplo, o intervalo entre as notas C e D é de um tom. Já o intervalo entre as notas E e F é de meio tom.")

        Subtitulo(titulo = "Características")
        Texto(texto = "Os intervalos podem ser:")
        Texto(texto = "1.1 - Melódicos: Formados por notas sucessivas. Na imagem abaixo você vê um intervalo de 2 tons entre as notas G e B, tocados sucessivamente.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_intervalo_melodico),
            contentDescription = "intervalo melodico"
        )

        Texto(texto = "1.2 - Harmônicos: Notas tocadas simultaneamente. Na imagem abaixo, é o mesmo intervalo tocado ao mesmo tempo")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_intervalo_harmonico),
            contentDescription = "intervalo harmonico"
        )

        Texto(texto = "2.1 - Ascendentes: A primeira nota é mais grave que a segunda. A imagem do item 1.1 é ascendente")

        Texto("2.2 - Descendentes: A primeira nota é mais aguda que a segunda. ")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_intervalo_descendente),
            contentDescription = "intervalo harmonico"
        )

        Texto("3.1 - Simples: As duas notas estão na mesma oitava.")

        Texto("3.2 - Composto: As duas notas estão em oitavas diferentes.")

        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, Intervalos2::class.java)
                activity?.startActivity(i)


            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Avançar", color = Color.White, fontSize = 20.sp)
        }

    }


}