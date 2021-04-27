package com.techdoctorbd.pokedex.data.repository

import com.techdoctorbd.pokedex.data.remote.PokemonApi
import com.techdoctorbd.pokedex.data.remote.responses.Pokemon
import com.techdoctorbd.pokedex.data.remote.responses.PokemonList
import com.techdoctorbd.pokedex.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RemoteRepository @Inject constructor(private val pokemonApi: PokemonApi) {

    suspend fun getPokemonList(queryMap: HashMap<String, String>): NetworkResult<PokemonList> {
        val response = try {
            pokemonApi.getPokemonList(queryMap)
        } catch (e: Exception) {
            return NetworkResult.Error(e.localizedMessage!!)
        }
        return NetworkResult.Success(response)
    }

    suspend fun getPokemonInfo(name: String): NetworkResult<Pokemon> {
        val response = try {
            pokemonApi.getPokemonInfo(name)
        } catch (e: Exception) {
            return NetworkResult.Error(e.localizedMessage!!)
        }
        return NetworkResult.Success(response)
    }
}