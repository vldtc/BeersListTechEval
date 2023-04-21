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

@Composable
fun BeerItem(beer: BeerItemModel) {
    // Display the details of a single beer
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(99.dp)
                .background(color = Color(0xFF4E4E4E))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "${beer.imageUrl}"),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 90.dp, width = 60.dp)
                    .weight(0.5f)
            )
            Text(
                text = "${beer.id}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1.5f)
                    .padding(start = 5.dp)
                    .align(Alignment.Top)
            )
            Text(text = "${beer.name}", color = Color.White, modifier = Modifier
                .weight(1f)
                .padding(start = 5.dp))
        }
    }
}