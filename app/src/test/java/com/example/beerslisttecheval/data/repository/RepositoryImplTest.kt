package com.example.beerslisttecheval.data.repository

import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {

    private lateinit var repository: RepositoryImpl
    private lateinit var fakeApiRequest: FakeApiRequest

    @Before
    fun setUp() {
        fakeApiRequest = FakeApiRequest()
        repository = RepositoryImpl(fakeApiRequest)
    }

    @Test
    fun testGetBeers() = runBlocking {
        // Given
        val expectedBeers = listOf(
            BeerItemModel(id =1, name = "Beer 1"),
            BeerItemModel(id=2,name= "Beer 2"),
            BeerItemModel(id=3, name="Beer 3")
        )
        fakeApiRequest.setMockedResponse(expectedBeers)

        // When
        val actualBeers = repository.getBeers()

        // Then
        assertThat(actualBeers).isEqualTo(expectedBeers)
    }

    @Test
    fun testGetBeers_emptyResponse() = runBlocking {
        // Given
        val expectedBeers = emptyList<BeerItemModel>()
        fakeApiRequest.setMockedResponse(expectedBeers)

        // When
        val actualBeers = repository.getBeers()

        // Then
        assertThat(actualBeers).isEmpty()
    }
    @Test
    fun testGetBeerItem() = runBlocking {
        // Given
        val expectedBeerItem = listOf(
            BeerItemModel(id =1, name = "Beer 1")
        )
        fakeApiRequest.setMockedResponse(expectedBeerItem)

        // When
        val actualBeers = repository.getBeerItem(1)

        // Then
        assertThat(actualBeers).isEqualTo(expectedBeerItem)
    }

    @Test
    fun testGetBeerItem_emptyResponse() = runBlocking {
        // Given
        val expectedBeers = emptyList<BeerItemModel>()
        fakeApiRequest.setMockedResponse(expectedBeers)

        // When
        val actualBeers = repository.getBeerItem(1)

        // Then
        assertThat(actualBeers).isEmpty()
    }
}