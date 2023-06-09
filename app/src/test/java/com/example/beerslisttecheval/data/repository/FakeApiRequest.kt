package com.example.beerslisttecheval.data.repository

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.remote.ApiRequest

class FakeApiRequest : ApiRequest {

    private var mockedResponse: List<BeerItemModel>? = null
    private var mockedError: Boolean = false

    fun setMockedResponse(beers: List<BeerItemModel>) {
        mockedResponse = beers
        mockedError = false
    }

    override suspend fun getBeers(): List<BeerItemModel> {
        return if (mockedError) {
            throw Exception("Error fetching beer list")
        } else {
            mockedResponse ?: emptyList()
        }
    }

    override suspend fun getBeerItem(id: Int): List<BeerItemModel> {
        return if(mockedError){
            throw Exception("Error fetching beer item!")
        }else{
            mockedResponse ?: emptyList()
        }
    }
}