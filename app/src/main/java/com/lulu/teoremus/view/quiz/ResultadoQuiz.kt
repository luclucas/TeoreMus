package com.lulu.teoremus.view.quiz

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.lulu.teoremus.R

class ResultadoQuiz : ComponentActivity() {
    private var categorias: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val i = intent

        val questoesCorretas = i.getIntExtra("questoes_corretas", 0)
        categorias = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            i.getSerializableExtra("lista_categorias", ArrayList<String>()::class.java)
        } else {
            @Suppress("Deprecation") i.getSerializableExtra("lista_categorias") as ArrayList<String>
        }
        setContent {
            Tela(questoesCorretas, categorias!!)
        }
    }
}

@Composable
private fun Tela(questoesCorretas: Int, categorias: ArrayList<String>) {
    var rating by remember {
        mutableStateOf(0f)
    }
    when (questoesCorretas) {
        in 0..1 -> rating = 0f
        in 2..4 -> rating = 1f
        in 5..7 -> rating = 2f
        in 8..10 -> rating = 3f
        else -> rating = 0f

    }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.cor_botoes_modulo))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        RatingBar(value = rating,
            painterEmpty = painterResource(id = R.drawable.colcheia_rating_vazia),
            painterFilled = painterResource(id = R.drawable.colcheia_rating_cheia),
            onValueChange = {},
            numOfStars = 3,
            size = 32.dp,
            spaceBetween = 5.dp,
            onRatingChanged = {})


        Text(text = "Você acertou $questoesCorretas questões", color = Color.Black)
        Text(text = "Você deve revisar: ", color = Color.Black)


        categorias.forEach {
            Text(text = it, color = Color.Black)
        }

    }

}