package com.lulu.teoremus.view.moduloi.clave_sol

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.Imagem
import com.lulu.teoremus.view.moduloi.ModuloI

class ClaveSol : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}
@Preview
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
        Titulo(titulo = "Clave de Sol")
        Texto(texto = "A Clave de Sol é este símbolo muito famoso: \uD834\uDD1E")
        
        Texto(texto = "Ela indica que a segunda linha da pauta é uma nota sol (lembre-se que as linhas são contadas de baixo para cima).")

        Texto(texto ="A imagem abaixo apresenta a escala de Dó maior escrita na clave de sol.")

        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp)
                .clickable {
                    val activity = (context as? Activity)
                    val intent = Intent(context, Imagem::class.java)
                    intent.putExtra("imagem", R.drawable.img_clave_sol)

                    activity?.startActivity(intent)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_clave_sol),
            contentDescription = "Clave"
        )

//        Image(
//            modifier = Modifier
//                .padding(top = 30.dp)
//                .fillMaxWidth()
//                .size(100.dp),
//            alignment = Alignment.Center,
//            painter = painterResource(id = R.drawable.img_clave_sol),
//            contentDescription = "Clave"
//        )
        
        Texto(texto = "Observe que também está sendo utilizada uma linha suplementar.")


        Button(onClick = {
            val activity = (context as? Activity)
            val i = Intent(context, ModuloI::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            activity?.startActivity(i)
            activity?.finish()


        }, Modifier.padding(30.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }

    }
}