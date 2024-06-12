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
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold,
//        fontSize = dimensionResource(id = R.dimen._16ssp).value.sp,
        fontSize = 16.sp
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp,
    ),
    bodySmall = TextStyle(
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
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
    ), titleSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
    ), labelSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )


)

