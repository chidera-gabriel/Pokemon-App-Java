package com.example.pokemonapp.retrofit;

import com.example.pokemonapp.models.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    // This is the hostname for the API

    String BASE_URL = "https://pokeapi.co";

     //API call to get the forecast from the Api
    @GET("api/v2/pokemon")
    Call<Pokemon>pokemonImage();

    @GET("api/v2/pokemon")
    Call<Pokemon>getName();

    @GET("api/v2/pokemon")
    Call<Pokemon>getType();

    @GET("api/v2/pokemon")
    Call<Pokemon>getHeight();
    @GET("api/v2/pokemon")
    Call<Pokemon>getWeight();
}
