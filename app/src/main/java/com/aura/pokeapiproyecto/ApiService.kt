package com.aura.pokeapiproyecto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // Obtener datos básicos de un Pokémon por su nombre
    @GET("https://pokeapi.co/api/v2/pokemon/{name}/")
    suspend fun getPokemon(@Path("name") pokemonName: String): Response<PokemonDataResponse>

    // Obtener detalles de un Pokémon por su ID
    //@GET("https://pokeapi.co/api/v2/pokemon/{id}/")
    //suspend fun getPokemonDetails(@Path("id") pokemonId: Int): Response<PokemonDetailResponse>
}
