package com.aura.pokeapiproyecto

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aura.pokeapiproyecto.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokemonFormViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemonItemResponse: PokemonDataResponse) {
        val nombre : String = pokemonItemResponse.name
        val typesPokemon = pokemonItemResponse.typePk.joinToString(", ") { it.typeOB.typeN }

        binding.tvPokemonName.text = buildString {
            append(nombre.substring(0, 1).uppercase())
            append("")
            append(nombre.substring(1).lowercase())
            append(" Shiny")
        }
        binding.tvPokemonType.text = typesPokemon
        pokemonItemResponse.id.toString().also { binding.tvPokemonOrder.text = it }
        Picasso.get().load(pokemonItemResponse.sprites.frontDefault.offArtwork.shinyUrl).into(binding.ivPokemon)



    }


}