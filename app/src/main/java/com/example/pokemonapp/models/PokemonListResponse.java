package com.example.pokemonapp.models;

import java.util.List;

public class PokemonListResponse {

    private List<PokemonListItem> outcome;

    public PokemonListResponse(List<PokemonListItem> outcome) {

        this.outcome = outcome;
    }

    public List<PokemonListItem> getOutcome() {
        return outcome;
    }
}
