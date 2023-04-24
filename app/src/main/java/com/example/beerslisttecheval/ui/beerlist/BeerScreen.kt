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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.navigation.Screen

// Main screen of the app
@Composable
fun BeerScreen(
    navController: NavController,
) {
    val viewModel = hiltViewModel<BeerScreenViewModel>()
    val beers by viewModel.beers.collectAsState()

    val navigateToDetails: (String) -> Unit = { beerId ->
        navController.navigate("${Screen.Details.route}/$beerId")

    }

    // Display the list of beers in a LazyColumn
    BeerContent(beersList = beers, navigateToDetails)
}

@Composable
fun BeerContent(
    beersList: List<BeerItemModel>,
    onClick: (String) -> Unit
){
    LazyColumn {
        items(beersList) { beer ->
            BeerItem(beer, onClick)
        }
    }
}
