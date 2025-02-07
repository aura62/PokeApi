
package com.aura.pokeapiproyecto

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aura.pokeapiproyecto.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso


class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemonItemResponse: PokemonDataResponse) {
        val nombre : String = pokemonItemResponse.name
        val typesPokemon = pokemonItemResponse.typePk.joinToString(", ") { it.typeOB.typeN } //un pokemon puede tener mas de 1 tipo

        binding.tvPokemonName.text = buildString {
            append(nombre.substring(0, 1).uppercase())
            append("")
            append(nombre.substring(1).lowercase())
        }
        binding.tvPokemonType.text = typesPokemon
        binding.tvPokemonOrder.id = pokemonItemResponse.id //el numero de orden de un pokemon en la pokedex, coincide con su id.
        Picasso.get().load(pokemonItemResponse.sprites.frontDefault.offArtwork.defaultUrl).into(binding.ivPokemon)
        Picasso.get().load(pokemonItemResponse.sprites.frontDefault.offArtwork.shinyUrl).into(binding.ivPokemonF)



    }
}