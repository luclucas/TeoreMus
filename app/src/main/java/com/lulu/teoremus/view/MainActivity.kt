package com.lulu.teoremus.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R


var listaImagens = listOf<Int>(R.drawable.img_semibreve, R.drawable.img_minima, R.drawable.img_seminima, R.drawable.img_colcheia)

var listaNomes = listOf("Módulo I", "Módulo II","Módulo III","Módulo IV",)

val listaTelas = listOf(ModuloI::class.java, ModuloII::class.java, ModuloIII::class.java, ModuloIV::class.java)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Tela() {
    Column() {
        for(i in listaNomes.indices){
            CardModulo(imagem = listaImagens[i], titulo = listaNomes[i], listaTelas[i])
        }

    }
}

@Composable
fun CardModulo(imagem: Int, titulo: String, tela: Class<out ComponentActivity>){
    val context = LocalContext.current
    Card(
        Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .clickable {
                       context.startActivity(Intent(context, tela))
            }
         , backgroundColor = colorResource(id = R.color.card_tela_principal)) {

        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {

            Image( painter = painterResource(id =  imagem), contentDescription = "Imagem módulo", Modifier.size(80.dp))

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){

                Text(text = titulo, color = Color.Yellow, fontSize = 30.sp)
                Text(text = "Descrição do módulo", color = Color.White, fontSize = 20.sp)
            }
        }
    }
}

