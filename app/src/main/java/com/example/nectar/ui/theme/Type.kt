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
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */

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
    /*font-family: Gilroy;
font-weight: 600;
font-size: 24px;
leading-trim: NONE;
line-height: 100%;
letter-spacing: 0%;
*/
    displayMedium = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
    )

)