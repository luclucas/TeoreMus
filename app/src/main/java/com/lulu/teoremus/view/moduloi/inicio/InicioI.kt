package com.lulu.teoremus.view.moduloi.inicio

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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.utils.*
import com.lulu.teoremus.view.Imagem
import com.lulu.teoremus.view.moduloi.ModuloI


class InicioI : ComponentActivity() {
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
    )
    {
        Titulo(titulo = "Início")
        Texto(texto = stringResource(id = R.string.inicio1))
        Subtitulo(titulo = "Melodia")
        Texto(texto = stringResource(id = R.string.inicio_melodia))
        Texto(texto = "Na imagem abaixo, você vê um trecho da música \"La vie en rose\", um exemplo de melodia.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_la_vie)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_la_vie),
            contentDescription = "Clave"
        )

        CaixaParaOuvir(texto = "Tocando no botão abaixo, você ouvirá a melodia da música.", midia = midia, escolha = Escolhas.MELODIA_LA_VIE, context = context)

//        Texto(texto = "Tocando no botão abaixo, você ouvirá a melodia da música.")
//
//        BotaoAudio(
//            texto = "Toque-me",
//            midia,
//            Escolhas.MELODIA_LA_VIE,
//            context
//        )

        CaixaDesafio("Preste mais atenção nas melodias das músicas que você ouve. Quais as diferenças entre elas? ")

        Subtitulo(titulo = "Harmonia")

        Texto(texto = "A harmonia se dá quando há duas ou mais notas tocadas ao mesmo tempo, por exemplo, um acorde")


        CaixaParaOuvir(texto = "Tocando no botão abaixo, você ouvirá o acorde de Dó maior.", midia = midia, escolha = Escolhas.C_VIOLAO, context = context)
//
//        Texto(texto = "Tocando no botão abaixo, você ouvirá o acorde de Dó maior")
//
//        BotaoAudio(
//            texto = "Toque-me",
//            midia,
//            Escolhas.C_VIOLAO,
//            context
//        )

        CaixaDesafio(texto = "Quando escutar uma música, preste atenção nos diferentes instrumentos que estão tocando e em como estão harmonizados")

        Subtitulo(titulo = "Ritmo")

        Texto(texto = "O ritmo se dá pela ordem e duração em que estão dispostos os sons e pausas, servindo como marcação")

        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, ModuloI::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity?.startActivity(i)
            activity?.finish()

        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }

}
