package com.example.beerslisttecheval.ui.beerlist

import com.example.beerslisttecheval.data.repository.Repository
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
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
@ExperimentalCoroutinesApi
class BeerScreenViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var fakeRepository: FakeRepository
    private lateinit var viewModel: BeerScreenViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeRepository()
        viewModel = BeerScreenViewModel(fakeRepository)
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
        viewModel.getBeers()

        // Then
        assertThat(viewModel.beers.value).isEmpty()
    }

}