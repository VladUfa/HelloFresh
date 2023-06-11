package com.example.hellofresh.ui

import androidx.lifecycle.ViewModel
import com.example.hellofresh.data.Recipe
import com.example.hellofresh.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    /**
     * Set the [desiredRecipe] of the list to view in Second Screen.
     */
    fun setRecipeID(desiredRecipe: Recipe) {
        _uiState.update { currentState ->
            currentState.copy(recipeID = desiredRecipe)
        }
    }
}