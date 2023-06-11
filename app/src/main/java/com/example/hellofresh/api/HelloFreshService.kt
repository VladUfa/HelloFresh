package com.example.hellofresh.api

import com.example.hellofresh.data.Recipe
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * JSON web site
 */
private const val BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/"

/**
 * for downloading JSON with Retrofit
 */
interface HelloFreshService {
    @GET("android-test/recipes.json")
    suspend fun getRecipes(): List<Recipe>

    companion object {
        var apiService: HelloFreshService? = null
        fun getInstance(): HelloFreshService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(HelloFreshService::class.java)
            }
            return apiService!!
        }
    }

}

