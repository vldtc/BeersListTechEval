package com.example.beerslisttecheval.data.model.beer


import com.example.beerslisttecheval.data.model.beer.AmountModel
import com.google.gson.annotations.SerializedName

data class HopModel(
    @SerializedName("add")
    val add: String? = "",
    @SerializedName("amount")
    val amount: AmountModel? = AmountModel(),
    @SerializedName("attribute")
    val attribute: String? = "",
    @SerializedName("name")
    val name: String? = ""
)