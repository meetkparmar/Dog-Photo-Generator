package com.example.dogphotogenerator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Button(
            onClick = { navController.navigate("generate") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate Dogs")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("recent") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("My Recently Generated Dogs")
        }
    }
}
