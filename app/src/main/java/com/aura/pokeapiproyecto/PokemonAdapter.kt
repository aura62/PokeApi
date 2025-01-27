package com.aura.pokeapiproyecto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(var pokemonObject : PokemonDataResponse? = null)  : RecyclerView.Adapter<PokemonViewHolder>() {

    fun updatePokemon(Pokemon: PokemonDataResponse?) {
        pokemonObject = Pokemon
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        pokemonObject?.let { holder.bind(it) }
    }

    override fun getItemCount() = if (pokemonObject!=null) 1 else 0
}