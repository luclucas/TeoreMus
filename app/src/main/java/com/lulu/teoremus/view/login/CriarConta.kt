package com.lulu.teoremus.view.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.lulu.teoremus.R
import com.lulu.teoremus.data.Resource
import com.lulu.teoremus.fontes.Typography
import com.lulu.teoremus.utils.CampoLogin
import com.lulu.teoremus.utils.CampoSenha
import com.lulu.teoremus.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class  CriarConta : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela(viewModel: AuthViewModel = hiltViewModel()) {
    val context = LocalContext.current as Activity
    var email by remember { mutableStateOf("") }
    var confirmarEmail by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }

    val criarContaFlow = viewModel.criarContaFlow.collectAsState()

    ConstraintLayout {
        val refLoading = createRef()


    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.35f)
                .background(color = Color(context.getColor(R.color.fundo_login))),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxSize()
            ) {

                Image(
                    modifier = Modifier.size(200.dp),
                    painter = painterResource(id = R.drawable.logo_teoremus),
                    contentDescription = ""
                )


                Spacer(modifier = Modifier.weight(1f))

                Text(text = "Criar Conta", color = Color.White,style = Typography.h2,modifier =  Modifier.padding(bottom = 10.dp))

            }

        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .weight(.65f)
                .clip(
                    RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                )
                .verticalScroll(rememberScrollState())
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                CampoLogin(value = nome, label = "Nome", onValueChange = {
                    nome = it
                }, R.drawable.icn_pessoa, "nome completo", keyboardType = KeyboardType.Text)


                CampoLogin(value = email, label = "E-mail", onValueChange = {
                    email = it
                }, R.drawable.icn_email, "Digite seu e-mail")


                CampoLogin(value = confirmarEmail, label = "Confirmar e-mail", onValueChange = {
                    confirmarEmail = it
                }, R.drawable.icn_email, "Digite seu e-mail")


                CampoSenha(senha = senha, label = "Senha", onValueChange = {
                    senha = it
                }, placeholder = "Digite uma senha")


                CampoSenha(senha = confirmarSenha, label = "Confirmar senha", onValueChange = {
                    confirmarSenha = it
                }, placeholder = "Digite novamente a senha")


               Button(
                    onClick = {
                        if(email == confirmarEmail && email.isNotEmpty() && senha == confirmarSenha && senha.isNotEmpty()) {
                            viewModel.criarConta(nome, email, senha, context)
                        } else{
                            Toast.makeText(context, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show()
                        }
                    },
                   Modifier
                       .padding(top = 40.dp)
                       .padding(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(context.getColor(R.color.cor_botoes_modulo))
                    )
                )
                {
                    Text(text = "Criar conta", color = Color.White, fontSize = 20.sp)
                }

                Row(
                    Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Já possui conta? ", fontSize = 16.sp)

                    Text(
                        text = "Fazer login",
                        Modifier
                            .clickable {
                                context.finish()
                                context.startActivity(Intent(context, Login::class.java))
                            },
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                    )
                }

            }
        }
    }
        criarContaFlow.value.let {
            when (it) {
                is Resource.Failure -> {
                    Toast.makeText(context, "Erro ao criar conta", Toast.LENGTH_SHORT).show()
                }

                Resource.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.constrainAs(refLoading){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
                }

                is Resource.Success -> {
                    val i = Intent(context, MainActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(i)
                    context.finish()
                }

                null -> {
                }

            }
        }
    }
    }
