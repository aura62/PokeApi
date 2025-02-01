package com.aura.pokeapiproyecto

import com.google.gson.annotations.SerializedName

// Respuesta principal del endpoint
data class PokemonDataResponse(
    @SerializedName("id") val id: Int, // ID del Pokémon
    @SerializedName("name") val name: String, // Nombre del Pokémon
    @SerializedName("types") val typePk : List<PokemonTypes>,
    @SerializedName("sprites") val sprites: PokemonSprites // Objeto con imágenes del Pokémon
)

// Objeto para las imágenes del Pokémon
data class PokemonSprites(
    @SerializedName("other") val frontDefault: PokemonArtwork // objeto que contiene otros con url
)

data class PokemonArtwork(
    @SerializedName("home") val offArtwork: PokemonDefault //objeto home que contiene url de los
// sprites para esa version
)

data class PokemonDefault(
    @SerializedName("front_default") val defaultUrl: String, // URL de la imagen principal
    @SerializedName("front_shiny") val shinyUrl: String // URL de la imagen para la version shiny
)

data class PokemonTypes(
    @SerializedName("type") val typeOB : PokemonTName //objeto type que contiene uno de los tipos
    //al que pertenece el pokemon
)

data class PokemonTName(
    @SerializedName("slot") val slot : Int, //parametro slot del objeto type
    @SerializedName("name") val typeN: String //parametro name del objeto type
)




