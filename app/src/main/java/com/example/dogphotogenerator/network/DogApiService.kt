package com.example.dogphotogenerator.network

import com.example.dogphotogenerator.models.DogImageResponse
import retrofit2.http.GET

interface DogApiService {

    @GET("breeds/image/random")
    suspend fun getRandomDog(): DogImageResponse
}