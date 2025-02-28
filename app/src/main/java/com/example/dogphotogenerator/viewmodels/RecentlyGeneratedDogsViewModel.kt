package com.example.dogphotogenerator.viewmodels

import androidx.lifecycle.ViewModel
import com.example.dogphotogenerator.network.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecentlyGeneratedDogsViewModel(private val repository: DogRepository) : ViewModel() {

    private val _dogImages = MutableStateFlow(listOf<String>())
    val dogImages: StateFlow<List<String>> = _dogImages

    private val _showLoading = MutableStateFlow(false)
    val showLoading: StateFlow<Boolean> = _showLoading

    init {
        _showLoading.value = true
        _dogImages.value = repository.getCachedDogs()
        _showLoading.value = false
    }

    fun clearDogs() {
        _showLoading.value = true
        repository.clearCache()
        _dogImages.value = emptyList()
        _showLoading.value = false
    }
}