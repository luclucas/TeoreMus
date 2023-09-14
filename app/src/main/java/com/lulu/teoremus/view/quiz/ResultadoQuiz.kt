package com.lulu.teoremus.view.quiz

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gowtham.ratingbar.RatingBar
import com.lulu.teoremus.R
import com.lulu.teoremus.view.MainActivity

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
    val context = LocalContext.current
    var rating by remember {
        mutableStateOf(0f)
    }

    var textoApresentacao by remember {
        mutableStateOf("")
    }
     when (questoesCorretas) {
        in 0..1 -> {
            rating = 0f
            textoApresentacao = "É preciso estudar mais"
        }
        in 2..4 -> {
            rating = 1f
            textoApresentacao = "Pode melhorar"
        }
        in 5..7 -> {
            rating = 2f
            textoApresentacao = "Muito bem, não desista de ganhar os 3 pontos"
        }
        in 8..10 -> {
            rating = 3f
            textoApresentacao = "Parabéns, você conseguiu absorver bem o conteúdo"}

    }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.cor_botoes_modulo))
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {





        TextoParabens(context)
        
        TextoInformacoes(texto = "Pontos")
        TextoPontos(pontos = questoesCorretas)

        RatingBar(value = rating,
            painterEmpty = painterResource(id = R.drawable.pontos_vazio_branco),
            painterFilled = painterResource(id = R.drawable.pontos_cheio),
            onValueChange = {},
            numOfStars = 3,
            size = 48.dp,
            spaceBetween = 2.dp,
            onRatingChanged = {},
            modifier = Modifier.padding(top = 30.dp, bottom = 10.dp))
        
        TextoInformacoes(texto = textoApresentacao)
        
        ConteudosRevisao(categorias = categorias)

        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            activity?.startActivity(i)
            activity?.finish()


        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            androidx.compose.material.Text(text = "Fechar", color = Color.White, fontSize = 20.sp)
        }


    }

}