package com.example.dogphotogenerator.network

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogRepository(private val context: Context) {

    private val Context.dataStore by preferencesDataStore("dog_cache")
    private val cacheKey = stringSetPreferencesKey("dog_images")

    private val api: DogApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)
    }

    suspend fun fetchRandomDog(): String {
        val response = api.getRandomDog()
        return response.message
    }

    fun addDogToCache(url: String) {
        runBlocking {
            context.dataStore.edit { preferences ->
                val currentList = preferences[cacheKey] ?: emptySet()
                val newList = (listOf(url) + currentList).take(20).toSet()
                preferences[cacheKey] = newList
            }
        }
    }

    fun getCachedDogs(): List<String> = runBlocking {
        context.dataStore.data.first()[cacheKey]?.toList() ?: emptyList()
    }

    fun clearCache() {
        runBlocking { context.dataStore.edit { it.clear() } }
    }
}