package com.lulu.teoremus.view.moduloiii.acordes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.utils.CaixaParaOuvir
import com.lulu.teoremus.utils.Midias
import com.lulu.teoremus.utils.Subtitulo
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo
import com.lulu.teoremus.view.moduloiii.ModuloIII

class Acordes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    Tela()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Tela() {
    val midia = Midias()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Acordes")
        
        Texto(texto = "Um acorde se dá pela combinação de três ou mais sons diferentes ao mesmo tempo.\n\nA combinação de dois sons é chamada de intervalo. Caso haja alguma dúvida, olhe o módulo anterior.")
        
        
        Texto(texto = "Geralmente, a criação dos acordes é feita a partir do campo harmônico, por exemplo, pegando o campo harmônico de C maior, temos as notas C, D, E, F, G, A e B.")
        
        Subtitulo(titulo = "Classificação dos acordes")
        
        Texto(texto = "Os acordes naturais são formados pela tônica, terça e quinta, e podem ser classificados em maior, menor e suspenso. Vamos analisar cada um deles.")
        
        Subtitulo(titulo = "Maiores")

        Texto(texto = "Os acordes maiores utilizam a terça maior. Por exemplo, o acorde de dó maior é formado por C E G.")

        Subtitulo(titulo = "Menores")

        Texto(texto = "Os acordes menores utilizam a terça menor. Para o acorde de dó menor, temos C Eb G.")

        Subtitulo(titulo = "Suspensos")

        Texto(texto ="Os acordes suspensos não possuem terça, sendo esta substituída pela segunda ou pela quarta. Por exemplo, Csus2 é formado por C D G e Csus4, por C F G.")
        
        CaixaParaOuvir(texto = "No botão abaixo você verá a diferença entre acorde maior, menor, e suspenso", midia = midia, escolha = Escolhas.ACORDE_MAIOR_MENOR_SUS, context = context)

        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, ModuloIII::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                activity?.startActivity(i)
                activity?.finish()

            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Finalizar", color = Color.White, fontSize = 20.sp)
        }

        
    }
}