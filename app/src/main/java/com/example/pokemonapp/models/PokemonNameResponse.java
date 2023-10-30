package com.example.pokemonapp.models;

import java.util.List;

public class PokemonNameResponse {
    private List<String> hints;

    public PokemonNameResponse(List<String> hints) {
        this.hints = hints;
    }

    public List<String> getHints() {
        return hints;
    }
}
