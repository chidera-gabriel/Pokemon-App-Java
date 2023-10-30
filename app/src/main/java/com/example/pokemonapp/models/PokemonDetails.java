package com.example.pokemonapp.models;

import java.util.List;

public class PokemonDetails {
    private int Id;
    private String name;
    private int height;
    private int weight;
    private List<PokemonType> types;

    private PokemonSprites sprites;

    public PokemonDetails(int Id, String name, int height, int weight, List<PokemonType> types,
                          PokemonSprites sprites) {
        this.Id = Id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.sprites = sprites;
    }

    public int getId() {
        return Id;
    }

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
    public PokemonSprites getSprites() { return sprites; }
}