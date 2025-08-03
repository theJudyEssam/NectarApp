package com.example.nectar.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.nectar.R

// Set of Material typography styles to start with

val Gilroy = FontFamily(
    Font(R.font.gilroyregular),
    Font(R.font.gilroybold, FontWeight.Bold),
    Font(R.font.gilroymedium, FontWeight.Medium)

)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    bodySmall = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),


    labelMedium = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center,
        color = GreyN
    ),

    titleMedium = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 18.sp
    ),

    displayLarge = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center
    ),


    displaySmall = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Medium,
        lineHeight = 15.sp,
        letterSpacing = 0.sp,
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    ),

    displayMedium = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 100.sp
    )

)