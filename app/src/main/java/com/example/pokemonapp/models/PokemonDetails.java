package com.example.pokemonapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonDetails {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<PokemonType> types;

    public PokemonDetails(int Id, String name, int height, int weight, List<PokemonType> types) {
        this.id = Id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
    }

    public int getId() {
        return id;
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
}