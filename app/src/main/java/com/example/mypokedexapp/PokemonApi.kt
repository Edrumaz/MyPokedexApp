package com.example.mypokedexapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://pokeapi.co/api/v2/"
val POKEMON_INFO = "pokemon"

interface PokemonApi {

    @GET("pokemon")
    fun getPokemon() : Call<List<Pokemon>>

    companion object {

        operator fun invoke() : PokemonApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonApi::class.java )
        }
    }
}