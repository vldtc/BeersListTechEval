package com.example.beerslisttecheval.data.remote

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.remote.ApiDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequest {
    @GET(ApiDetails.BEER)
    suspend fun getBeers(): List<BeerItemModel>

    @GET(ApiDetails.BEER_ITEM)
    suspend fun getBeerItem(@Path("id") id: Int): List<BeerItemModel>

}