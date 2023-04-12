package com.lulu.teoremus.view.moduloi.notas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lulu.teoremus.R
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.ferramentas.*
import com.lulu.teoremus.view.moduloi.notas.ui.theme.TeoreMusTheme

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

        Texto(texto ="Dó - C\n" +
                "Ré - D\n" +
                "Mi -  E\n" +
                "Fá -  F\n" +
                "Sol - G\n" +
                "Lá -  A\n" +
                "Si -   B")

        Texto(texto = "A nota \"Si\" também é representada como H na notação alemã")

        Subtitulo(titulo = "Partitura")

        Texto(texto = "Outra maneira de representar as notas é por meio das partituras\n" +
                "Na imagem abaixo, você pode ver um exemplo de como elas são escritas: ")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_escala_c_i),
            contentDescription = "Escala dó"
        )

        CaixaParaOuvir(texto = "Toque no botão abaixo para ouvir a escala de dó maior", midia = midia, escolha = Escolhas.ESCALA_C, context = context)
    }
}
