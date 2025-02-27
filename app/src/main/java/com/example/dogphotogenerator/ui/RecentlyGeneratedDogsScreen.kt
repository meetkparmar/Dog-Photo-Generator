package com.example.dogphotogenerator.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import coil.compose.rememberAsyncImagePainter
import com.example.dogphotogenerator.viewmodels.RecentlyGeneratedDogsViewModel

@Composable
fun RecentlyGeneratedDogsScreen(viewModel: RecentlyGeneratedDogsViewModel) {
    val images by viewModel.dogImages.collectAsState()

    Column {
        Button(onClick = { viewModel.clearDogs() }) {
            Text("Clear Dogs")
        }

        Column {
            images.forEach {
                Image(painter = rememberAsyncImagePainter(it), contentDescription = "Dog Image")

            }
        }
    }
}
