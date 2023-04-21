package com.example.beerslisttecheval.ui.beerlist

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.repository.Repository

class FakeRepository : Repository {

    private val beers = mutableListOf<BeerItemModel>()

    override suspend fun getBeers(): List<BeerItemModel> {
        return beers.toList()
    }

    fun addBeers(newBeers: List<BeerItemModel>) {
        beers.addAll(newBeers)
    }

    fun clearBeers() {
        beers.clear()
    }
}


