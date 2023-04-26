package com.example.beerslisttecheval.ui.beerlist

import com.example.beerslisttecheval.ui.beerdetails.BeerDetailsViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class BeerScreenViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var fakeRepository: FakeRepository
    private lateinit var viewModelBeerScreen: BeerScreenViewModel
    private lateinit var viewModelBeerItem: BeerDetailsViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeRepository()
        viewModelBeerScreen = BeerScreenViewModel(fakeRepository)
        viewModelBeerItem = BeerDetailsViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test getBeers handles repository error and updates state`() = runTest {
        // Given
        fakeRepository.clearBeers()

        // When
        viewModelBeerScreen.getBeers()

        // Then
        assertThat(viewModelBeerScreen.beers.value).isEmpty()
    }

}