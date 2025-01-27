package com.aura.pokeapiproyecto

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aura.pokeapiproyecto.databinding.ActivityPokemonListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonListActivity : AppCompatActivity(){

    private lateinit var binding: ActivityPokemonListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()

        initUi()
    }

    private fun initUi() {
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })



    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse : Response<PokemonDataResponse> =
                retrofit.create(ApiService::class.java).getPokemon(query.lowercase())
            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
                val response: PokemonDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                }
            } else {
                Log.i("Consulta", "No funciona :(")
            }


        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://pokeapi.co/api/v2/") // Base URL without query parameters
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}