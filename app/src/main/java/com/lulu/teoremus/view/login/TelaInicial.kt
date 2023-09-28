package com.lulu.teoremus.view.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.auth.FirebaseUser
import com.lulu.teoremus.R
import com.lulu.teoremus.data.Resource
import com.lulu.teoremus.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TelaInicial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela()
        }
    }
}

@Composable
private fun Tela(viewModel: AuthViewModel = hiltViewModel()){
    val context = LocalContext.current as Activity

    viewModel.logout()

    val userFlow: FirebaseUser? = viewModel.currentUser
    if (userFlow != null){
        val i = Intent(context, MainActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(i)
        context.finish()
    }



//    val userFlow = viewModel.currentUser
//
//    if (userFlow != null){
//        context.startActivity(Intent(context, MainActivity::class.java))
//        context.finish()
//    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .background(
            color = colorResource(
                id = R.color.fundo_login
            )
        )
        .padding(30.dp)) {
        Image(painter = painterResource(id = R.drawable.logo_teoremus), contentDescription = "",
            Modifier.size(200.dp))

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = {
            context.startActivity(Intent(context, Login::class.java))},
            Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth()
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.roxo)
            )
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }

        Button(onClick = {
            context.startActivity(Intent(context, CriarConta::class.java))},
            Modifier
                .padding(start = 40.dp, end = 40.dp, top = 10.dp)
                .fillMaxWidth()
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.laranja)
            )
        ) {
            Text(text = "Criar conta", fontSize = 20.sp)
        }

    }
}