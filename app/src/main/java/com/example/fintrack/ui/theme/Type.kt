package com.example.fintrack.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fintrack.R

// Set of Material typography styles to start with

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_thin, FontWeight.Thin)
)

val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 16.sp
    ), bodyMedium = TextStyle(
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp,
    ), bodySmall = TextStyle(
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium, fontSize = 15.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 52.14.sp,
    ), titleMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
    ), titleSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ), labelMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ), labelSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
    ), headlineMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )


)

