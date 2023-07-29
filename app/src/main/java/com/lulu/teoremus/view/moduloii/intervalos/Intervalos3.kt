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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.view.moduloii.ModuloII

class Intervalos3 : ComponentActivity() {
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
        Subtitulo(titulo = "Qualitativamente")
        Texto(texto = "A classificação de acordo com a qualidade é feita com base no número de tons e semitons contidos no intervalo. Se divide em dois tipos, os justos e os maiores ou menores")

        Texto(texto = "Justos:\n\nprimeira justa (1ª j) - mesmo tom e altura;\n\nquartaª justa (4ª j) - 2 tons e 1 semitom;\n\nquinta justa (5ª j) - 3 tons e 1 semitom;\n\noitava justa (8ª j) - 5 tons e 2 semitons.")

        Texto(texto = "Maiores ou menores:\n\nsegunda maior (2ª M) - 1 tom;\n\nsegunda menor (2ª m) - 1 semitom;\n\nterça maior (3ª M) - 2 tons;\n\nterça menor (3ª m) - 1 tom e 1 semitom;\n\nsexta maior (6ª M) - 4 tons e 1 semitom;\n\nsexta menor (6ª m) - 3 toms e 2 semitons;\n\nsétima maior (7ª M) - 5 tons e 1 semitom;\n\nsétima menor (7ª m) - 4 tons e 2 semitons.")


        Subtitulo(titulo = "Intervalos aumentados e diminutos")

        Texto("Intervalos aumentados: são os que tem um semitom acima dos justos")


        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_quarta_aumentadal),
            contentDescription = "4 aumentada"
        )

        Texto(texto = "Intervalos diminutos: são os que tem um semitom abaixo dos justos")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_quarta_diminuta),
            contentDescription = "4 diminuta"
        )

        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, ModuloII::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity?.startActivity(i)
            activity?.finish()

        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }

}