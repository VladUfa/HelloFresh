package com.example.hellofresh

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
//    private val userService = retrofit.create(HelloFreshService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

//        GlobalScope.launch(Dispatchers.Main) {
//            try {
//                val recipes = withContext(Dispatchers.IO) { userService.getRecipes() }
//                for (recipe in recipes) {
//                    print(recipe.calories)
//                }
//            } catch (e: Exception) {
//                // Handle error
//                e.printStackTrace()
//            }
//        }

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
