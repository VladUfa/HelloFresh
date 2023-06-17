package com.example.hellofresh.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hellofresh.api.HelloFreshService
import com.example.hellofresh.data.Recipe
import com.example.hellofresh.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _recipesList = mutableStateListOf<Recipe>()
    val recipesList: List<Recipe>
        get() = _recipesList

    private var errorMessage: String = ""

    init {
        getRecipesList()
    }

    /**
     * Set the [desiredRecipe] of the list to view in Second Screen.
     */
    fun setRecipe(desiredRecipe: Recipe) {
        _uiState.update { currentState ->
            currentState.copy(selectedRecipe = desiredRecipe)
        }
    }

    /**
     * Publishes the RecipeList and has a getRecipeList function
     * for the view to use to fetch all recipes

     */

    private fun getRecipesList() {
        viewModelScope.launch {
            val apiService = HelloFreshService.getInstance()
            try {
                _recipesList.clear()
                _recipesList.addAll(apiService.getRecipes())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}