package com.example.beerslisttecheval.navigation

import dagger.hilt.android.AndroidEntryPoint

enum class Screen(val route: String, var header: String){

    BeerList(route = "beer_screen", header = "Beer List"),
    Details(route = "beer_details_screen", header = "Beer Item")
}
