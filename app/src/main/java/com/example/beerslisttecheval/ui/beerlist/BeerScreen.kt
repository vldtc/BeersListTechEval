package com.example.beerslisttecheval.ui.beerlist

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
    var query by remember { mutableStateOf("") }

    val navigateToDetails: (String) -> Unit = { beerId ->
        navController.navigate("${Screen.Details.route}/$beerId")
    }

    val filteredBeers = remember(beers, query) {
        if (query.isBlank()) {
            beers
        } else {
            beers.filter { beer ->
                beer.name?.contains(query, ignoreCase = true) ?: false
            }
        }
    }


    Column {
        SearchBar(query){value ->
            query = value
        }
        BeerContent(filteredBeers, navigateToDetails)
    }
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

@Composable
fun SearchBar(
    query: String,
    onSearch: (String) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = {
            onSearch(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp),
        singleLine = true,
        placeholder = { Text(text = "Search by beer name...") },
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(10.dp)
    )
}

