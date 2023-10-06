package com.lulu.teoremus.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.gowtham.ratingbar.RatingBar
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.SHARED_USER_KEY
import com.lulu.teoremus.view.moduloi.ModuloI
import com.lulu.teoremus.view.moduloii.ModuloII
import com.lulu.teoremus.view.moduloiii.ModuloIII
import com.lulu.teoremus.view.moduloiv.ModuloIV
import com.lulu.teoremus.view.ranking.RankingScreen


var listaImagens = listOf<Int>(
    R.drawable.img_semibreve,
    R.drawable.img_minima,
    R.drawable.img_seminima,
    R.drawable.img_colcheia
)

var listaNomes = listOf("Módulo I", "Módulo II", "Módulo III", "Módulo IV")

val listaTelas =
    listOf(ModuloI::class.java, ModuloII::class.java, ModuloIII::class.java, ModuloIV::class.java)

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val listaPontosModulos = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]


        val preferences = getSharedPreferences(SHARED_USER_KEY, Context.MODE_PRIVATE)
        listaPontosModulos.add(preferences.getInt("moduloI", 0))
        listaPontosModulos.add(preferences.getInt("moduloII", 0))
        listaPontosModulos.add(preferences.getInt("moduloIII", 0))
        listaPontosModulos.add(preferences.getInt("moduloIV", 0))



        setContent {
            Tela(viewModel, listaPontosModulos)
        }
    }

}




@Composable
private fun Tela(viewModel: MainActivityViewModel, list: MutableList<Int>) {
    Log.d("lulutag", "user = ${viewModel.user.value}")
    Column() {
        for (i in listaNomes.indices) {
            CardModulo(imagem = listaImagens[i], titulo = listaNomes[i], listaTelas[i], list[i])
        }

        CardRanking(imagem = R.drawable.hanking, titulo = "Placar")

    }
}

@Composable
fun CardModulo(imagem: Int, titulo: String, tela: Class<out ComponentActivity>, pontos: Int) {
    val context = LocalContext.current
    Card(
        Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .clickable {
                context.startActivity(Intent(context, tela))
            }, backgroundColor = colorResource(id = R.color.card_tela_principal)
    ) {

        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = painterResource(id = imagem),
                contentDescription = "Imagem módulo",
                Modifier.size(80.dp)
            )

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = titulo, color = Color.Yellow, fontSize = 30.sp)


                RatingBar(
                    value = pontos.toFloat(),
                    painterEmpty = painterResource(id = R.drawable.pontos_vazio_branco),
                    painterFilled = painterResource(id = R.drawable.pontos_cheio),
                    onValueChange = {},
                    numOfStars = 3,
                    size = 24.dp,
                    spaceBetween = 0.4.dp,
                    onRatingChanged = {},
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}


@Composable
fun CardRanking(imagem: Int, titulo: String) {
    val context = LocalContext.current
    Card(
        Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth()
            .clickable {
                context.startActivity(Intent(context, RankingScreen::class.java))
            }, backgroundColor = colorResource(id = R.color.card_tela_principal)
    ) {

        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = painterResource(id = imagem),
                contentDescription = "Imagem módulo",
                Modifier.size(80.dp)
            )

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = titulo, color = Color.Yellow, fontSize = 30.sp)

            }
        }
    }
}

