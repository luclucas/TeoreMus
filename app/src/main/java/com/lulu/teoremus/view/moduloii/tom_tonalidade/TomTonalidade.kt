package com.lulu.teoremus.view.moduloii.tom_tonalidade

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloii.ModuloII

class TomTonalidade : ComponentActivity() {
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

        Titulo(titulo = "Tom e tonalidade")

        Texto(texto = "Agora veremos os conceitos e diferenças de tom e tonalidade. Embora pareçam a mesma coisa, possuem significados diferentes. Porém no dia a dia é bem comum ver pessoas utilizando ambos os termos com a mesma intenção.")
        Subtitulo(titulo = "Tom")
        Texto(texto = "O termo \"TOM\" tem relação com a altura em que está a tonalidade, ou seja, terá o mesmo conjunto de notas que a escala, mas não necessariamente na ordem. Dizemos que uma música está no tom de determinada nota, quando esta nota é a tônica.")

        Subtitulo(titulo = "Tonalidade")

        Texto(texto = "A TONALIDADE se refere às escalas associadas ao campo harmônico, pode ser maior, menor, menor harmônica e menor melódica.")

        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, ModuloII::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            activity?.startActivity(i)
            activity?.finish()

        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            androidx.compose.material.Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }
    }
}
