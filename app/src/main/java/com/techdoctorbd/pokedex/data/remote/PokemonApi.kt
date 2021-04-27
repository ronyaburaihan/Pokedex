package com.techdoctorbd.pokedex.data.remote

import com.techdoctorbd.pokedex.data.remote.responses.Pokemon
import com.techdoctorbd.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(@QueryMap queryMap: HashMap<String, String>): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String): Pokemon
}