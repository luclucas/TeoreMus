package com.lulu.teoremus.utils

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
fun BotaoAudio(texto: String, midia: Midias, escolha: Escolhas, context: Context) {
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
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    style = Typography.body1,
                    textAlign = TextAlign.Center
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
                    icone,
                    "Icone",
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
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    style = Typography.body1,
                    textAlign = TextAlign.Center

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
                        text = "Toque-me",
                        color = colorResource(id = R.color.texto_botao_mod),
                        fontSize = 18.sp,
                        style = Typography.body1,

                        )
                }
            }
        }
    }
}


@Composable
fun CaixaParaOuvir2(texto: String, midia: Midias, escolhas: List<Escolhas>, context: Context) {
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
                    icone,
                    "Icone",
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
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    style = Typography.body1,
                    textAlign = TextAlign.Center

                )

                for (i in escolhas) {
                    Button(
                        onClick = {
                            midia.alterarEscolha(i, context)
                            midia.start()

                        }, modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                            .padding(20.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.cor_botoes_modulo))
                    ) {
                        Text(
                            text = "Toque-me",
                            color = colorResource(id = R.color.texto_botao_mod),
                            fontSize = 18.sp,
                            style = Typography.body1,

                            )
                    }
                }
            }
        }
    }
}


@Composable
fun CaixaResposta(texto: String) {
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
                    text = "Resposta",
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
                        .padding(10.dp)
                        .fillMaxWidth(),

                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    style = Typography.body1,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun Tabela(titulos: List<String>,data: List<List<String>>, columns: Int) {

    val columnWeight = 1/columns.toFloat() // 30

    // The LazyColumn will be our table. Notice the use of the weights below
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Here is the header

        Row(Modifier.background(Color(R.color.azul_claro))) {
            for(i in titulos){
                TableCell(text = i, weight = columnWeight)
            }
        }
        // Here are all the lines of your table.

        for (i in data) {
            Row(Modifier.fillMaxWidth()) {
                for (j in 0 until columns){
                    TableCell(text = i[j], weight = columnWeight)

                }
            }
        }
    }
}


@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(8.dp)

    )
}



@Composable
fun CampoLogin(
    value: String, label: String, onValueChange: (String) -> Unit, icon: Int,
    placeholder: String, imeAction: ImeAction = ImeAction.Next, keyboardType: KeyboardType = KeyboardType.Email
) {

    Column(
        Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {

        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)

        OutlinedTextField(
            value = value, onValueChange = onValueChange,
            label = { Text(text = label) },
            placeholder = { Text(placeholder) },
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            singleLine = true,
            leadingIcon = { Icon(painter = painterResource(icon), contentDescription = "") },
            textStyle = TextStyle(
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun CampoSenha(
    senha: String, label: String, onValueChange: (String) -> Unit,
    placeholder: String, imeAction: ImeAction = ImeAction.Done
) {

    val showPassword = remember { mutableStateOf(false) }
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {

        Text(text = "Senha", fontWeight = FontWeight.Bold, fontSize = 14.sp)

        OutlinedTextField(
            value = senha, onValueChange = onValueChange,
            label = { Text(text = label) },
            placeholder = { Text(placeholder) },
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = imeAction
            ),
            visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),


            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icn_senha),
                    contentDescription = ""
                )
            },

            trailingIcon = {
                val icon = if(showPassword.value){
                    painterResource(R.drawable.icn_mostrar_senha)
                } else{
                    painterResource(R.drawable.icn_esconder_senha)
                }
                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(painter = icon, contentDescription = " ")
                }
            },
            textStyle = TextStyle(
                fontSize = 14.sp
            )
        )
    }
}