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

    private val _showLoading = MutableStateFlow(false)
    val showLoading: StateFlow<Boolean> = _showLoading

    fun generateDog() {
        viewModelScope.launch {
            _showLoading.value = true
            val response = repository.fetchRandomDog()
            repository.addDogToCache(response)
            _dogUrl.value = response
            _showLoading.value = false
        }
    }
}