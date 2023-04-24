package com.example.beerslisttecheval.ui.beerdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beerslisttecheval.data.model.beer.BeerItemModel
import com.example.beerslisttecheval.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {

    val beerDetails = MutableStateFlow(BeerItemModel())

    fun getBeerItem(beerId: Int){
        viewModelScope.launch {
            val result = repository.getBeerItem(beerId)[0]
            beerDetails.value = result
        }
    }

}