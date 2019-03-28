package com.example.mypokedexapp

import com.google.gson.annotations.SerializedName

data class Pokemon (

    //val id: Int,
    @SerializedName("name")
    val name: String,
    //val type1: String,
    //val type2: String,
    @SerializedName("url")
    val description: String

)