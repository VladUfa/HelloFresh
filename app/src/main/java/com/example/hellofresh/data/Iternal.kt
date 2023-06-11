package com.example.hellofresh.data

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.hellofresh.R
import com.example.hellofresh.api.HelloFreshService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getTime(data: Recipe): String {
    return data.time.substring(2, 4)+" min"
}

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
val difficultyImages = listOf(
    R.drawable.l1,
    R.drawable.l2,
    R.drawable.l3,
    R.drawable.l4
)
private const val BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
//val userService = retrofit.create(HelloFreshService::class.java)
