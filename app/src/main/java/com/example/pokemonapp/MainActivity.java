package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pokemonapp.databinding.ActivityMainBinding;
import com.example.pokemonapp.models.Pokemon;
import com.example.pokemonapp.retrofit.RetrofitClient;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        // Creating and initializing the Api  client
        Call<Pokemon> call = RetrofitClient.getInstance().getApi().pokemonImage();
        Call<Pokemon> call1 = RetrofitClient.getInstance().getApi().getName();
        Call<Pokemon> call2 = RetrofitClient.getInstance().getApi().getType();
        Call<Pokemon> call3 = RetrofitClient.getInstance().getApi().getHeight();
        Call<Pokemon> call4 = RetrofitClient.getInstance().getApi().getWeight();








    }
}