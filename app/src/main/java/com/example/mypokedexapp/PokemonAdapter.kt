package com.example.mypokedexapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_cardview_layout.view.*

class PokemonAdapter(val pokemons : List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.pokemon_cardview_layout, parent, false)
        )
    }

    override fun getItemCount() = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]

      //  holder.view.tv_pokemon_id.text = pokemon.id.toString()
        holder.view.tv_pokemon_name.text = pokemon.name
      //  holder.view.tv_type_1.text = pokemon.type1
      //  holder.view.tv_type_2.text = pokemon.type2
        holder.view.tv_pokemon_description.text = pokemon.description
    }

    class PokemonViewHolder (val view: View) : RecyclerView.ViewHolder(view)
}