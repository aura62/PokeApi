package com.aura.pokeapiproyecto

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aura.pokeapiproyecto.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokemonViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemonItemResponse: PokemonDataResponse){

        binding.tvPokemonName.text = pokemonItemResponse.name
        Picasso.get().load(pokemonItemResponse.sprites.frontDefault.offArtwork.url).into(binding.ivPokemon)

    }

}
