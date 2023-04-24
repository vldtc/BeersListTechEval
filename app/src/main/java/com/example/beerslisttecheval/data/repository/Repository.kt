package com.example.beerslisttecheval.data.repository

import com.example.beerslisttecheval.data.model.beer.BeerItemModel

interface Repository {

    suspend fun getBeers(): List<BeerItemModel>

    suspend fun getBeerItem(id: Int): List<BeerItemModel>

}