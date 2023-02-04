package com.lulu.teoremus.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ModuloI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Texto()

        }
    }
}

@Composable
fun Texto(){
    Text(text = "oi")
}

@Composable
fun BotoesAula(){
    IconButton(onClick = { /*TODO*/ }) {
        
    }
}