package com.example.hellofresh

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hellofresh.ui.RecipeViewModel
import com.example.hellofresh.ui.screens.StartHelloFreshScreen
import com.example.hellofresh.ui.screens.ViewRecipeScreen
import com.example.hellofresh.ui.theme.firaInder

/**
 * List of routes according to applications screens
 */
enum class HelloFreshScreen {
    Start,
    Recipe
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloFreshAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name), fontFamily = firaInder) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

/**
 * Composable that displays the main screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloFreshApp(
    recipeViewModel: RecipeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    /**
     * Check this code later. It is somehow needed to correctly check the expression
     * navController.previousBackStackEntry != null
     */
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = HelloFreshScreen.valueOf(
        backStackEntry?.destination?.route ?: HelloFreshScreen.Start.name
    )

    val jsonData = recipeViewModel.recipesList
    val uiState by recipeViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            HelloFreshAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        /**
         * Initializing NavHost for displaying the current destination
         */
        NavHost(
            navController = navController,
            startDestination = HelloFreshScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            /**
             * Main screen with list of recipes
             */
            composable(route = HelloFreshScreen.Start.name) {
                StartHelloFreshScreen(
                    jsonData,
                    onNextButtonClicked = {
                        recipeViewModel.setRecipe(it)
                        navController.navigate(HelloFreshScreen.Recipe.name) },
                )
            }
            /**
             * Second screen with chosen recipe
             */
            composable(route = HelloFreshScreen.Recipe.name) {
                ViewRecipeScreen(
                    uiState = uiState,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}

