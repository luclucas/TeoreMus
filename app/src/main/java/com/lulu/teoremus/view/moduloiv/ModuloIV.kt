package com.lulu.teoremus.view.moduloiv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ModuloIV : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextoIV()

        }
    }
}

@Composable
fun TextoIV(){
    Text(text = "oi")
}

