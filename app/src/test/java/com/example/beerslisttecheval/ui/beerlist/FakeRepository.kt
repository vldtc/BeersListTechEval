package com.example.beerslisttecheval.ui.beerlist

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.repository.Repository

class FakeRepository : Repository {

    private val beers = mutableListOf<BeerItemModel>()
    private val beerItem = mutableListOf<BeerItemModel>()

    override suspend fun getBeers(): List<BeerItemModel> {
        return beers.toList()
    }

    override suspend fun getBeerItem(id: Int): List<BeerItemModel> {
        return beerItem.toList()
    }

    fun clearBeers() {
        beers.clear()
    }
}


