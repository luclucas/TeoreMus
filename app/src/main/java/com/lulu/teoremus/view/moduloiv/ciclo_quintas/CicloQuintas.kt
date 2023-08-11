package com.lulu.teoremus.view.moduloiv.ciclo_quintas

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
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.Imagem
import com.lulu.teoremus.view.moduloiv.ModuloIV

class CicloQuintas : ComponentActivity() {
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
        Titulo(titulo = "Ciclo das quintas")

        Texto(texto = "O ciclo das quintas é uma forma de organização das notas para que seja facilitada a compreensão de quais tons terão acidendes (sustenidos e bemois) e a quantidade deles.")

        Texto(texto = "É feito contando a quinta justa da nota atual e cada vez que for passando para a próxima nota, é adicionado um sustenido na sétima da nova nota. Por exemplo, começando pelo tom de C maior, temos as notas C, D, E, F, G, A e B.")

        Texto(texto = "A quinta justa de C é a nota G, logo o próximo tom será G maior, e como a sétima nota vira sustenido, temos G, A, B, C, D, E e F#.")

        Texto(texto = "A quinta justa de G é a nota D, tem-se, então D, E, F#, G, A, B, C#.")

        Texto(texto = "E assim sucessivamente. Na imagem abaixo você terá a tabela do ciclo das quintas, contendo a quantidade de sustenidos e quais são eles. Ter esse conhecimento auxilia na criação de músicas e improvisação, visto que você saberá quais notas pertencem a determinado tom.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_ciclo_quintas)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_ciclo_quintas),
            contentDescription = "Clave"
        )


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
