package com.lulu.teoremus.ferramentas

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.fontes.Typography


@Composable
fun Titulo(titulo: String) {
    Text(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        text = titulo,
        style = Typography.h1,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.card_tela_principal)
    )

}

@Composable
fun Subtitulo(titulo: String) {
    Text(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        text = titulo,
        style = Typography.h2,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.cor_botoes_modulo)
    )

}

@Composable
fun Texto(texto: String) {
    Text(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        text = texto,
        style = Typography.body1,
        textAlign = TextAlign.Center
    )
}

@Composable
fun BotaoAudio(texto: String, midia: Midias, escolha: Escolhas, context: Context ) {
    Button(
        onClick = {
            midia.alterarEscolha(escolha, context)
            midia.start()

        }, modifier = Modifier
            .padding(top = 20.dp)
            .padding(20.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.cor_botoes_modulo))
    ) {
        Text(
            text = texto, color = colorResource(id = R.color.texto_botao_mod), fontSize = 18.sp,
            style = Typography.body1
        )
    }

}

@Composable
fun CaixaDesafio(texto: String) {
    val expandido = remember {
        mutableStateOf(false)
    }
    val icone =
        if (!expandido.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp
    val extraPadding = if (expandido.value) 20.dp else 0.dp
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.card_tela_principal),
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 20.dp + extraPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = "Desafio",
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.texto_botao_quiz),
                    style = Typography.body1
                )

                Icon(
                    icone, "Icone",
                    Modifier
                        .padding(top = 5.dp, start = 60.dp)
                        .size(30.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                        .clickable { expandido.value = !expandido.value },
                    tint = colorResource(id = R.color.card_tela_principal)
                )

            }
            if (expandido.value) {
                Text(
                    text = texto,
                    Modifier
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(10.dp),
                    color = colorResource(id = R.color.black)
                    ,
                    fontSize = 20.sp,
                    style = Typography.body1
                )
            }
        }
    }
}

@Composable
fun CaixaParaOuvir(texto: String, midia: Midias, escolha: Escolhas, context: Context) {
    val expandido = remember {
        mutableStateOf(false)
    }
    val icone =
        if (!expandido.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp
    val extraPadding = if (expandido.value) 20.dp else 0.dp
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.fundo_para_ouvir),
                shape = RoundedCornerShape(10.dp)
            )
           // .clickable { expandido.value = !expandido.value },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 20.dp + extraPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = "Para Ouvir",
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.card_tela_principal),
                    style = Typography.body1
                )

                Icon(
                    icone, "Icone",
                    Modifier
                        .padding(top = 5.dp, start = 60.dp)
                        .size(30.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                        .clickable { expandido.value = !expandido.value }
                    , tint = colorResource(id = R.color.card_tela_principal)

                )

            }
            if (expandido.value) {
                Text(
                    text = texto,
                    Modifier
                        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(10.dp),
                    color = colorResource(id = R.color.black)
                    ,
                    fontSize = 20.sp,
                    style = Typography.body1
                )

                Button(
                    onClick = {
                        midia.alterarEscolha(escolha, context)
                        midia.start()

                    }, modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.cor_botoes_modulo))
                ) {
                    Text(
                        text = "Toque-me", color = colorResource(id = R.color.texto_botao_mod), fontSize = 18.sp,
                        style = Typography.body1
                    )
                }
            }
        }
    }
}