package com.lulu.teoremus.view.moduloii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ModuloII : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextoII()

        }
    }
}

@Composable
fun TextoII(){
    Text(text = "oi")
}

