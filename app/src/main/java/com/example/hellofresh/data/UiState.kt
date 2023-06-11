package com.example.hellofresh.data

/**
 * Data class that represents the current UI state
 */
data class UiState(
    /** Selected recipe */
    val recipeID: Recipe = Recipe(name = "")
//    val recipeID: String = "",
    //val recipe: Recipe
)
