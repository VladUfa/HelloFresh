package com.example.hellofresh

/**
 *  !!!!!!!!!!!!!!
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.hellofresh.ui.theme.HelloFreshTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //val vm = Recipe2ViewModel()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

//        val test = listOf(testRecipe, testRecipe)

        setContent {
            HelloFreshTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call for main composable with layouts
                    HelloFreshApp()
                }
            }
        }

    }
}
