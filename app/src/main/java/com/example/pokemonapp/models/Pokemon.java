package com.example.pokemonapp.models;

import android.widget.ImageView;

public class Pokemon {

    private ImageView pokemonImage;
    private String name;
    private String type;
    private int height;
    private int weight;

    public Pokemon(ImageView pokemonImage, String name, String type, int height, int weight) {
        this.pokemonImage = pokemonImage;
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
    }

    public ImageView getPokemonImage() {
        return pokemonImage;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
