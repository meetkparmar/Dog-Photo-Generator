package com.example.dogphotogenerator.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import coil.compose.rememberAsyncImagePainter
import com.example.dogphotogenerator.viewmodels.GenerateDogViewModel

@Composable
fun GenerateDogScreen(viewModel: GenerateDogViewModel) {
    val dogUrl by viewModel.dogUrl.collectAsState()

    Column {
        Button(onClick = { viewModel.generateDog() }) {
            Text("Generate!")
        }

        if (dogUrl.isNotEmpty()) {
            Image(painter = rememberAsyncImagePainter(dogUrl), contentDescription = "Dog Image")
        }
    }
}
