package com.lulu.teoremus.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ModuloIII : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextoIII()

        }
    }
}

@Composable
fun TextoIII(){
    Text(text = "oi")
}

