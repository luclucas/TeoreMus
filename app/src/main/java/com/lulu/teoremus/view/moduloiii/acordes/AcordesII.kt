package com.lulu.teoremus.view.moduloiii.acordes

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
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.utils.CaixaParaOuvir
import com.lulu.teoremus.utils.Midias
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.view.moduloiii.ModuloIII

class AcordesII : ComponentActivity() {
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

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Subtitulo(titulo = "Quinta")

        Texto(texto = "Tomando como base a quinta, os acordes são classificados em normais, aumentados e diminutos.")

        Subtitulo(titulo = "Normais")

        Texto(texto = "Os acordes maiores utilizam a quinta justa, ou seja, 3 tons e meio de distância da tônica para a quinta. Exemplo, C e G")

        Subtitulo(titulo = "Aumentados")

        Texto(texto = "Os acordes aumentados têm a quinta aumentada, ou seja, eleva-se em meio tom a quinta. Exemplo, C e G#")

        Subtitulo(titulo = "Diminutos")

        Texto(texto = "Os acordes com a quinta diminuta possuem ela meio tom abaixo. Por exemplo, C e Gb. Geralmente são utilizados em acordes diminutos ou meio diminutos, veremos esse conteúdo mais para frente")

        CaixaParaOuvir(
            texto = "No botão abaixo você verá a diferença entre acorde maior, menor, sus2 e sus4",
            midia = midia,
            escolha = Escolhas.ACORDE_NORMAL_AUMENTADO_DIMINUTO,
            context = context
        )

        Button(
            onClick = {
                midia.stop()
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