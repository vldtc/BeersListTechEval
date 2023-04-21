package com.example.beerslisttecheval.data.remote

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.remote.ApiDetails
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.BEER)
    suspend fun getBeers(): List<BeerItemModel>
}