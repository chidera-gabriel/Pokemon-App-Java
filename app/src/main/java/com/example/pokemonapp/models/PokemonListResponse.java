package com.example.pokemonapp.models;

import java.util.List;

public class PokemonListResponse {

    List<PokemonListItem> results;

    public PokemonListResponse(List<PokemonListItem> results) {

        this.results = results;
    }

    public List<PokemonListItem> getResults() {
        return results;
    }
}
