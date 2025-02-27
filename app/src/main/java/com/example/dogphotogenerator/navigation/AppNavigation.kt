package com.example.dogphotogenerator.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dogphotogenerator.network.DogRepository
import com.example.dogphotogenerator.ui.GenerateDogScreen
import com.example.dogphotogenerator.ui.HomeScreen
import com.example.dogphotogenerator.ui.RecentlyGeneratedDogsScreen
import com.example.dogphotogenerator.viewmodels.GenerateDogViewModel
import com.example.dogphotogenerator.viewmodels.GenerateDogViewModelFactory
import com.example.dogphotogenerator.viewmodels.RecentlyGeneratedDogsViewModel
import com.example.dogphotogenerator.viewmodels.RecentlyGeneratedDogsViewModelFactory

@Composable
fun AppNavigation(navController: NavHostController) {
    val repository = DogRepository(navController.context)

    val generateDogViewModel: GenerateDogViewModel = viewModel(factory = GenerateDogViewModelFactory(repository))
    val recentlyGeneratedDogsViewModel: RecentlyGeneratedDogsViewModel = viewModel(factory = RecentlyGeneratedDogsViewModelFactory(repository))

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("generate") { GenerateDogScreen(generateDogViewModel) }
        composable("recent") { RecentlyGeneratedDogsScreen(recentlyGeneratedDogsViewModel) }
    }
}
