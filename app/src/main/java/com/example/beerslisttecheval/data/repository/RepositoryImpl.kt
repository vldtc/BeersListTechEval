package com.example.beerslisttecheval.data.repository

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.remote.ApiRequest
import com.example.beerslisttecheval.data.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
) : Repository {

    override suspend fun getBeers(): List<BeerItemModel> = apiRequest.getBeers()
    override suspend fun getBeerItem(id: Int): List<BeerItemModel> = apiRequest.getBeerItem(id)

}