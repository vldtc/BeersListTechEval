package com.example.beerslisttecheval.ui.beerdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.beerslisttecheval.data.model.beer.BeerItemModel

@Composable
fun BeerDetailsScreen(
    beerId: Int
) {

    val viewModel = hiltViewModel<BeerDetailsViewModel>()
    val beerItem: BeerItemModel by viewModel.beerDetails.collectAsState()

    viewModel.getBeerItem(beerId)
    BeerDetailsContent(beerDetails = beerItem)
}

@Composable
fun BeerDetailsContent(
    beerDetails: BeerItemModel
) {
    Column() {
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .height(99.dp)
                        .background(color = Color(0xFFD1D1D1))
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = "${beerDetails.imageUrl}"),
                        contentDescription = null,
                        modifier = Modifier
                            .size(height = 90.dp, width = 60.dp)
                            .weight(0.5f)
                            .padding(5.dp)
                    )
                    Text(
                        text = "${beerDetails.id}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 10.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${beerDetails.name}",
                        color = Color.Black,
                        modifier = Modifier
                            .weight(3f)
                            .padding(end = 5.dp),
                        textAlign = TextAlign.End
                    )
                }
            }
        }
        Column() {
            Text(
                text = "${beerDetails.description}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Text(
                text = "First brew: ${beerDetails.firstBrewed}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

