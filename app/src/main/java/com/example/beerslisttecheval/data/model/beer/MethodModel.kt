package com.example.beerslisttecheval.data.model.beer


import com.example.beerslisttecheval.data.model.beer.FermentationModel
import com.google.gson.annotations.SerializedName

data class MethodModel(
    @SerializedName("fermentation")
    val fermentation: FermentationModel? = FermentationModel(),
    @SerializedName("twist")
    val twist: String? = ""
)