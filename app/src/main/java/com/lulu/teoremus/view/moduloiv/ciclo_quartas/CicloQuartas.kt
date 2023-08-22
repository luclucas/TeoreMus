package com.lulu.teoremus.view.moduloiv.ciclo_quartas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.lulu.teoremus.utils.CaixaDesafio
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.Imagem
import com.lulu.teoremus.view.moduloiv.ModuloIV

class CicloQuartas : ComponentActivity() {
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
        Titulo(titulo = "Ciclo das quartas")

        Texto(texto = "O ciclo das quartas é bem semelhante ao ciclo das quintas, porém é utilizada para os acidentes bemois a contagem é feita de quatro em quatro notas e a quarta nota do tom atual é que vira bemol.")

        Texto(texto = "Por exemplo, sabemos que o tom de C maior tem as notas C, D, E, F, G, A e B. A quarta justa de C é F, logo teremos as notas F G A Bb C D E.")

        Texto(texto = "E assim sucessivamente. Em alguns locais você verá o ciclo das quintas abrangendo também os bemois além dos sustenidos, mas não há problema em utilizar ambos os ciclos, podendo ser até mais didático.")

        Texto(texto = "Abaixo temos a imagem com o ciclo das quartas.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_ciclo_quartas)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_ciclo_quartas),
            contentDescription = "Clave"
        )
        
        CaixaDesafio(texto = "Veja quais notas cada tom tem em comum com os outros.")


        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, ModuloIV::class.java)
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