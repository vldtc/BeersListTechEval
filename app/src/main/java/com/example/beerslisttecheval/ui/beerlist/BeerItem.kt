package com.example.beerslisttecheval.ui.beerlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.beerslisttecheval.data.model.beer.BeerItemModel

@Composable
fun BeerItem(beer: BeerItemModel) {
    // Display the details of a single beer
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .height(99.dp)
                .background(color = Color(0xFFD1D1D1))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "${beer.imageUrl}"),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 90.dp, width = 60.dp)
                    .weight(0.5f)
                    .padding(5.dp)
            )
            Text(
                text = "${beer.id}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 10.dp),
                fontSize = 20.sp
            )
            Text(
                text = "${beer.name}",
                color = Color.Black,
                modifier = Modifier
                    .weight(3f)
                    .padding(end = 5.dp),
                textAlign = TextAlign.End
            )
        }
    }
}