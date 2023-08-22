package com.lulu.teoremus.fontes

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
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