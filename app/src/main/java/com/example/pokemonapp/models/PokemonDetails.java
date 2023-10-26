package com.example.pokemonapp.models;

import java.util.List;

public class PokemonDetails {
    private String name;
    private int height;
    private int weight;
    private List<PokemonType> types;
    private PokemonSprites sprites;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }
}
