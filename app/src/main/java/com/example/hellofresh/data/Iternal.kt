package com.example.hellofresh.data

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.hellofresh.R
import com.example.hellofresh.api.HelloFreshService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Get formatted time preparation string from Json raw data
 */
fun getTime(data: Recipe): String {
    return data.time.substring(2, 4)+" min"
}


/**
 * List of images for showing difficulty level in layouts
 */
val difficultyImages = listOf(
    R.drawable.l1,
    R.drawable.l2,
    R.drawable.l3,
    R.drawable.l4
)

