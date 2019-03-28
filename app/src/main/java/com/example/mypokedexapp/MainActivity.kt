package com.example.mypokedexapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            PokemonApi().getPokemon().enqueue(object: Callback<List<Pokemon>>{
                override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                    val pokemons = response.body()
                    pokemons?.let {
                        showPokemons(it)
                    }
                }
            })
        }

    private fun showPokemons(pokemons: List<Pokemon>){
        rv_pokemon.layoutManager = LinearLayoutManager(this)
        rv_pokemon.adapter = PokemonAdapter(pokemons)
    }

    // https://medium.com/@jassmel05/consume-restful-api-with-kotlin-1b9b14db3f28
}
