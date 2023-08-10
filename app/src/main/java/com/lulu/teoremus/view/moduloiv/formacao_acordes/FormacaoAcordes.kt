package com.lulu.teoremus.view.moduloiv.formacao_acordes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lulu.teoremus.R
import com.lulu.teoremus.enums.Escolhas
import com.lulu.teoremus.utils.CaixaParaOuvir
import com.lulu.teoremus.utils.Midias
import com.lulu.teoremus.utils.Texto
import com.lulu.teoremus.utils.Titulo

class FormacaoAcordes : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela() {
    val context = LocalContext.current
    val midia = Midias()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Titulo(titulo = "Formação de acordes")

        Texto(texto = "Vimos no módulo anterior que os acordes possuem a tônica, terça e quinta (eventualmente, pode haver a sétima).")

        Texto(texto = "Porém, não significa que as notas devam aparecer apenas uma vez. Em alguns casos, pode-se repetir a nota para que ela dê uma sonoridade diferente do mesmo acorde, mas com apenas três notas.")

        Texto(texto = "Na imagem abaixo, você pode ter diferentes formas de tocar o acorde de Dó")


        Image(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .size(100.dp),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.img_formacao_acordes),
            contentDescription = "Clave"
        )

        CaixaParaOuvir(
            texto = "Aqui você pode ouvir os sons representados pela imagem acima",
            midia = midia,
            escolha = Escolhas.FORMACAO_ACORDES,
            context = context
        )

        Texto(texto = "Os acordes não precisam ser formados na ordem tônica, terça, quinta. Caso ela seja alterada, o fenômeno se chama inversão de acorde, estudaremos esse conteúdo mais tarde.")

        Button(
            onClick = {
                val activity = (context as? Activity)
                val i = Intent(context, FormacaoAcordes2::class.java)
                activity?.startActivity(i)
            },
            Modifier.padding(30.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Text(text = "Avançar", color = Color.White, fontSize = 20.sp)
        }
    }


}
