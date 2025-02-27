package com.example.dogphotogenerator.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogphotogenerator.network.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GenerateDogViewModel(private val repository: DogRepository) : ViewModel() {

    private val _dogUrl = MutableStateFlow("")
    val dogUrl: StateFlow<String> = _dogUrl

    fun generateDog() {
        viewModelScope.launch {
            val response = repository.fetchRandomDog()
            repository.addDogToCache(response)
            _dogUrl.value = response
        }
    }
}