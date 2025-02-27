package com.example.dogphotogenerator.viewmodels

import androidx.lifecycle.ViewModel
import com.example.dogphotogenerator.network.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecentlyGeneratedDogsViewModel(private val repository: DogRepository) : ViewModel() {

    private val _dogImages = MutableStateFlow(listOf<String>())
    val dogImages: StateFlow<List<String>> = _dogImages

    init {
        _dogImages.value = repository.getCachedDogs()
    }

    fun clearDogs() {
        repository.clearCache()
        _dogImages.value = emptyList()
    }
}