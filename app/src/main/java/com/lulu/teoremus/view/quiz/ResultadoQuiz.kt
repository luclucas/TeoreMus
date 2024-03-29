package com.lulu.teoremus.view.quiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.gowtham.ratingbar.RatingBar
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.SHARED_USER_KEY
import com.lulu.teoremus.utils.await
import com.lulu.teoremus.view.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ResultadoQuiz : ComponentActivity() {
    private var categorias: ArrayList<String>? = null
    private var questoesErradas: ArrayList<String>? = null
    private var rating = 0f
    private lateinit var textoApresentacao: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val i = intent

        val modulo = i.getStringExtra("modulo")
        Log.d("modulo", "$modulo")
        val questoesCorretas = i.getIntExtra("questoes_corretas", 0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            categorias = i.getSerializableExtra("lista_categorias", ArrayList<String>()::class.java)
            questoesErradas =
                i.getSerializableExtra("questoes_erradas", ArrayList<String>()::class.java)
        } else {
            categorias =
                @Suppress("Deprecation") i.getSerializableExtra("lista_categorias") as ArrayList<String>
            questoesErradas =
                @Suppress("Deprecation") i.getSerializableExtra("questoes_erradas") as ArrayList<String>
        }
        getRating(questoesCorretas)
        GlobalScope.launch {

            atualizarPontos(this@ResultadoQuiz, modulo!!, rating.toInt())
        }

        setContent {
            Tela(questoesCorretas, categorias!!, questoesErradas!!, modulo!!, rating, textoApresentacao)
        }
    }

    private fun getRating(questoesCorretas: Int){
        when (questoesCorretas) {
            in 0..2 -> {
                rating = 0f
                textoApresentacao = "É preciso estudar mais"
            }

            in 3..5 -> {
                rating = 1f
                textoApresentacao = "Pode melhorar"
            }

            in 6..8 -> {
                rating = 2f
                textoApresentacao = "Muito bem, não desista de ganhar os 3 pontos"
            }

            in 9..10 -> {
                rating = 3f
                textoApresentacao = "Parabéns, você conseguiu absorver bem o conteúdo"
            }

        }
    }

}

private suspend fun atualizarPontos(context: Context, modulo: String, rating: Int) {

    val preferences = context.getSharedPreferences(SHARED_USER_KEY, Context.MODE_PRIVATE)
    val currentPoint = preferences.getInt(modulo, 0)
    var total = preferences.getInt("total", 0)
    val editor = preferences.edit()
    if (currentPoint < rating) {
        total += rating - currentPoint
        val auth = FirebaseAuth.getInstance()
        val userRef = auth.currentUser
        val db = FirebaseFirestore.getInstance()
        val dbRef = db.collection("Usuarios").document(userRef!!.uid).update(modulo, rating, "total", total)
        Log.d("lulutag", "${dbRef.await()}")
        editor.putInt("total", total)
        editor.putInt(modulo, rating).apply()
    }


}



@Composable
private fun Tela(
    questoesCorretas: Int,
    categorias: ArrayList<String>,
    questoesErradas: ArrayList<String>,
    modulo: String,
    rating: Float,
    textoApresentacao: String
) {
    val context = LocalContext.current

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

        RatingBar(
            value = rating,
            painterEmpty = painterResource(id = R.drawable.pontos_vazio_branco),
            painterFilled = painterResource(id = R.drawable.pontos_cheio),
            onValueChange = {},
            numOfStars = 3,
            size = 48.dp,
            spaceBetween = 2.dp,
            onRatingChanged = {},
            modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
        )

        TextoInformacoes(texto = textoApresentacao)

        ConteudosRevisao("Questões erradas", categorias = questoesErradas)

        ConteudosRevisao("Para revisar", categorias = categorias)

        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                activity?.startActivity(i)
                activity?.finish()


            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            androidx.compose.material.Text(text = "Fechar", color = Color.White, fontSize = 20.sp)
        }


    }

}

