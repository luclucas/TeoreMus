package com.lulu.teoremus.view.quiz

import android.content.Context
import android.graphics.Paint
import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.fontes.heebo

@Composable
fun CaixaAlternativa(texto: String? = " ", onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 30.dp)
            .clip(shape = RoundedCornerShape(100.dp))
            .background(color = Color.White)
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        Text(
            text = texto!!,
            Modifier
                .padding(20.dp)
                .fillMaxWidth()
            // .clip(shape = RoundedCornerShape(100.dp))
            //   .align(Alignment.Center),
            ,
            fontSize = 20.sp,
            color = Color.Black,
            fontFamily = heebo,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TextoQuestao(texto: String? = "") {
    Text(
        text = texto!!,
        Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        color = Color.White,
        fontSize = 20.sp,
        fontFamily = heebo,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextoPontos(pontos: Int) {

    val color = if (pontos <= 4) Color.Red else colorResource(id = R.color.texto_botao_quiz)

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = "$pontos",
            color = color,
            fontSize = 35.sp,
            fontFamily = heebo,
            textAlign = TextAlign.Center
        )

        Text(
            text = " / 10",
            color = colorResource(id = R.color.white),
            fontSize = 35.sp,
            fontFamily = heebo,
            textAlign = TextAlign.Center
        )

    }

}

@Composable
fun TextoInformacoes(texto: String) {
    Text(
        text = texto,
        Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        color = Color.White,
        fontSize = 20.sp,
        fontFamily = heebo,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextoParabens(context: Context) {

    Canvas(modifier = Modifier.size(width = 300.dp, height = 150.dp)) {
        drawIntoCanvas {
            val textPadding = 30.dp.toPx()
            val arcHeight = 150.dp.toPx()
            val arcWidth = 300.dp.toPx()

            // Path for curved text
            val path = Path().apply {
                addArc(0f, textPadding, arcWidth, arcHeight, 180f, 180f)
            }
            it.nativeCanvas.drawTextOnPath(
                "Parabéns",
                path,
                0f,
                0f,
                Paint().apply {
                    textSize = 45.sp.toPx()
                    textAlign = Paint.Align.CENTER
                    color = context.getColor(R.color.white)
                }
            )
        }
    }
}

@Composable
fun ConteudosRevisao(categorias: ArrayList<String>) {

    Column(
        Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Para revisar",
            fontSize = 30.sp,
            color = colorResource(id = R.color.card_tela_principal),
            fontFamily = heebo
        )

        categorias.forEach {
            Text(
                text = it, fontSize = 20.sp, color = colorResource(id = R.color.cor_botoes_modulo),
                fontFamily = heebo
            )
        }
    }
}
