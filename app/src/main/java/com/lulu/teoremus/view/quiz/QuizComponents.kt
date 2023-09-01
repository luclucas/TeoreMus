package com.lulu.teoremus.view.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.fontes.heebo

@Composable
fun CaixaAlternativa(texto: String? = " "){
    Box(modifier = Modifier
        .padding(top = 30.dp)
        .background(color = Color.White)
        .fillMaxWidth()
        .padding(20.dp)){
        Text(text = texto!!, Modifier.align(Alignment.Center), fontSize = 20.sp, color = Color.Black, fontFamily = heebo)
    }
}

@Composable
fun TextoQuestao(texto: String?=""){
    Text(text = texto!!, color = Color.White, fontSize = 20.sp, fontFamily = heebo)
}
