package com.lulu.teoremus.view.moduloii.escalas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.utils.CaixaParaOuvir
import com.lulu.teoremus.utils.Midias
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo

class Escalas : ComponentActivity() {
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
        Titulo(titulo = "Escala")

        Texto(texto = "A escala pode pode ser definida como uma sucessão ordenadas de sons (ascendente e descendente) e que estão no limite de uma oitava.")

        Texto(texto = "A palavra vem do latim \"scala\" e significa \"escada\"")

        Texto(texto = "Elas podem ser classificadas pelo número de notas ou pela utilização.")

        Texto(texto = "Pelo número de notas, temos:")
        Texto(texto = "1) 5 notas - pentatônica;\n\n2) 6 notas - hexacordal;\n\n3) 7 notas - heptatônica;\n\n4) 12 notas - cromática.")

        Texto(texto = "Pela utilização, temos: ")
        Texto(texto = "1) Escalas naturais ou diatônicas;\n\n2) Escalas artificiais ou cromáticas;\n\n3) Escalas exóticas e outras.")

        Subtitulo(titulo = "Escala natural")

        Texto(texto = "É uma sequência de 7 notas diferentes consecutivas, separadas pelo intervalo de um ou meio tom")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_escala_c_i),
            contentDescription = "escala c"
        )

        CaixaParaOuvir(
            texto = "Ouça a escala de dó maior",
            midia = midia,
            escolha = Escolhas.ESCALA_C,
            context = context
        )


        Subtitulo(titulo = "Escala cromática")

        Texto(texto = "É a sequência de 12 semitons consecutivos.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_escala_cromatica),
            contentDescription = "escala c"
        )

        CaixaParaOuvir(
            texto = "Ouça a escala de dó maior",
            midia = midia,
            escolha = Escolhas.ESCALA_CROMATICA,
            context = context
        )


        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, EscalasII::class.java)
            activity?.startActivity(i)


        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            Text(text = "Avançar", color = Color.White, fontSize = 20.sp)
        }
    }

}