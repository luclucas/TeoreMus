package com.lulu.teoremus.view.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Modifier.padding(20.dp).fillMaxWidth(),
        color = Color.White,
        fontSize = 20.sp,
        fontFamily = heebo,
        textAlign = TextAlign.Center
    )
}
