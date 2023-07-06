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
import com.lulu.teoremus.ferramentas.Subtitulo
import com.lulu.teoremus.ferramentas.Texto
import com.lulu.teoremus.view.moduloii.ModuloII

class EscalasII : ComponentActivity() {
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
        Subtitulo(titulo = "Escala Maior")

        Texto(texto = "A escala maior é dada pelos intervalos: T T sT T T T sT. Na imagem abaixo você poderá ver a escala de Dó maior")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_escala_maior),
            contentDescription = "escala c"
        )


        Subtitulo(titulo = "Escala Menor")
        Texto(texto = "A escala menor é dada pelos intervalos: T sT T T sT T T. Na imagem abaixo você poderá ver a escala de Lá menor.")


        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(120.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_escala_menor),
            contentDescription = "escala c"
        )

        Texto(texto = "Note que as notas em ambas as escalas são as mesmas, o que muda é o tom e a tonalidade, que veremos a seguir.")

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
