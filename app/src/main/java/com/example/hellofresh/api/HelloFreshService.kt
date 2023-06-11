package com.example.hellofresh.api

import com.example.hellofresh.data.Recipe
import retrofit2.http.GET


interface HelloFreshService {
    @GET("android-test/recipes.json")
    suspend fun getRecipes(): List<Recipe>
}
