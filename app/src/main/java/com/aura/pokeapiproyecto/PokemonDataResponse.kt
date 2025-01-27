package com.aura.pokeapiproyecto

import com.google.gson.annotations.SerializedName

// Respuesta principal del endpoint
data class PokemonDataResponse(
    @SerializedName("id") val id: Int, // ID del Pokémon
    @SerializedName("name") val name: String, // Nombre del Pokémon
    @SerializedName("sprites") val sprites: PokemonSprites, // Objeto con imágenes del Pokémon
)

// Objeto para las imágenes del Pokémon
data class PokemonSprites(
    @SerializedName("front_default") val frontDefault: String // URL de la imagen principal
)
