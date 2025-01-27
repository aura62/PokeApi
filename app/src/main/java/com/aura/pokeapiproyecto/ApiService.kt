package com.aura.pokeapiproyecto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // Obtener datos básicos de un Pokémon por su nombre
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") pokemonName: String): Response<PokemonDataResponse>

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(@Path("id") pokemonId: Int) : Response<PokemonSpeciesResponse>

    @GET("evolution-shain/{id}")
    suspend fun getPokemonEvolutionShain(@Path("id") pkcId : Int) : Response<PokemonEvolutionResponse>
}

