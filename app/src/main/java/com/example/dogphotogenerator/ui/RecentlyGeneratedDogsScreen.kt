package com.example.dogphotogenerator.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.dogphotogenerator.R
import com.example.dogphotogenerator.viewmodels.RecentlyGeneratedDogsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentlyGeneratedDogsScreen(
    navController: NavController,
    viewModel: RecentlyGeneratedDogsViewModel
) {
    val images by viewModel.dogImages.collectAsState()
    val showLoading by viewModel.showLoading.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = stringResource(R.string.generate_dogs_title))
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() })
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (showLoading) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.TopCenter),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .horizontalScroll(rememberScrollState())
                ) {
                    images.forEach {
                        AsyncImage(
                            modifier = Modifier.size(200.dp),
                            model = it,
                            contentDescription = "cache Image",
                            contentScale = ContentScale.None
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.Center)
                    .padding(16.dp),
                onClick = { viewModel.clearDogs() }) {
                Text(stringResource(R.string.clear_dogs))
            }
        }
    }
}
