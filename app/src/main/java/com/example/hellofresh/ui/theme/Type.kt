package com.example.hellofresh.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hellofresh.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
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
)

/**
 * Fonts using in the app
 */
val firaInika = FontFamily(
    Font(R.font.inika, FontWeight.Normal),
)
val firaIstok = FontFamily(
    Font(R.font.istok_web, FontWeight.Normal),
    Font(R.font.istok_web_bold, FontWeight.Bold),
)
val firaItim = FontFamily(
    Font(R.font.itim, FontWeight.Normal),
)
val firaInder = FontFamily(
    Font(R.font.inder, FontWeight.Normal),
)
val firaJulius = FontFamily(
    Font(R.font.julius_sans_one, FontWeight.Normal),
)
