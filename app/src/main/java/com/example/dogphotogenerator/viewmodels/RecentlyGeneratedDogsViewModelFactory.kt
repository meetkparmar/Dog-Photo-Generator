package com.example.dogphotogenerator.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dogphotogenerator.network.DogRepository

class RecentlyGeneratedDogsViewModelFactory(private val repository: DogRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecentlyGeneratedDogsViewModel::class.java)) {
            return RecentlyGeneratedDogsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
