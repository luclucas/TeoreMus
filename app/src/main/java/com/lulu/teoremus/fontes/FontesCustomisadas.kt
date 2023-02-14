package com.lulu.teoremus.fontes

import android.content.Context
import android.content.res.Resources
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.lulu.teoremus.R

val lilita = FontFamily(
    Font(R.font.lilita_one_regular)
)
val heebo = FontFamily(
    Font(R.font.heebo_medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = lilita,
        fontSize = 40.sp,

    ),
    h2 = TextStyle(
        fontFamily = lilita,
        fontSize = 30.sp,
    ),
    body1 = TextStyle(
        fontFamily = heebo,
        fontSize = 20.sp
    )
)