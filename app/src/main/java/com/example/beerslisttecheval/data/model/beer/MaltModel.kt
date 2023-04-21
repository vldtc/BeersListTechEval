package com.example.beerslisttecheval.data.model.beer


import com.example.beerslisttecheval.data.model.beer.AmountModel
import com.google.gson.annotations.SerializedName

data class MaltModel(
    @SerializedName("amount")
    val amount: AmountModel? = AmountModel(),
    @SerializedName("name")
    val name: String? = ""
)