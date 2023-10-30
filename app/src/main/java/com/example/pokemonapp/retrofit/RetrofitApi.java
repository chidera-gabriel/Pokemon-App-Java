package com.example.pokemonapp.retrofit;

import com.example.pokemonapp.models.PokemonDetails;
import com.example.pokemonapp.models.PokemonListResponse;
import com.example.pokemonapp.models.PokemonNameResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApi {

    // The hostname for the API
    String BASE_URL = "https://pokeapi.co";

    // API call to get a list of Pokemon characters with a limit and offset
    @GET("api/v2/pokemon/?limit=1500&offset=0")
    Call<PokemonListResponse> getPokemonList(@Query("limit") int limit,
                                             @Query("offset") int offset);

    // API call to get details for an individual Pokemon by name
    @GET("api/v2/pokemon/{name}")
    Call<PokemonDetails> getPokemonDetails(@Path("name") String name);
}