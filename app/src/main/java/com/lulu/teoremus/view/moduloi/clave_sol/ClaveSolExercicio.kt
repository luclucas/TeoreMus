package com.lulu.teoremus.view.moduloi.clave_sol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lulu.teoremus.R
import com.lulu.teoremus.utils.CaixaResposta
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo



class ClaveSolExercicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela() {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Exercício")

        Texto(texto = "Quais são as notas abaixo? Anote a resposta em uma folha e depois confira o resultado")

        Row() {

            Image(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .size(150.dp),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.img_exerciciocs_sol),
                contentDescription = "Clave"
            )

            Spinner()
        }
        Row() {

            Image(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .size(150.dp),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.img_exerciciocs_c),
                contentDescription = "Clave"
            )

            Spinner()


        }

        Row() {

            Image(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .size(150.dp),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.img_exerciciocs_a),
                contentDescription = "Clave"
            )

            Spinner()
        }
        Row() {

            Image(
                modifier = Modifier
                    .padding(end = 30.dp)
                    .size(150.dp),
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.img_exerciciocs_d),
                contentDescription = "Clave"
            )

            Spinner()
        }

        CaixaResposta(texto = "1º G\n2º C\n3º A\n4º D")
    }
}

@Composable
fun Spinner() {
    val notes = listOf("C", "D", "E", "F", "G", "A", "B")
    var expanded = remember { mutableStateOf(false) }
    var currentValue = remember {
        mutableStateOf(notes[0])
    }

    Box(
        Modifier
            .padding(top = 50.dp)
            .border(1.dp, Color.Black)
            .padding(10.dp),) {
        Row(modifier = Modifier.clickable {
            expanded.value = !expanded.value
        }) {

            Text(text = currentValue.value)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")

            DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
                notes.forEach {
                    DropdownMenuItem(onClick = {
                        currentValue.value = it
                        expanded.value = false
                    }

                    ) {
                        Text(text = it)
                    }

                }
            }
        }

    }

}