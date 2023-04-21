package com.example.beerslisttecheval.ui.beerlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.beerslisttecheval.data.model.beer.BeerItemModel

@Composable
fun BeerScreen(
    mainScreenViewModel: BeerScreenViewModel = viewModel()
) {
    val beers by mainScreenViewModel.beers.collectAsState()

    // Display the list of beers in a LazyColumn
    LazyColumn {
        items(beers) { beer ->
            BeerItem(beer)
        }
    }
}
