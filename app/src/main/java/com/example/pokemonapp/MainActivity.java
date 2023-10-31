package com.example.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.pokemonapp.databinding.ActivityMainBinding;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.bumptech.glide.Glide;
import com.example.pokemonapp.models.PokemonDetails;
import com.example.pokemonapp.models.PokemonListItem;
import com.example.pokemonapp.models.PokemonListResponse;
import com.example.pokemonapp.models.PokemonType;
import com.example.pokemonapp.retrofit.RetrofitClient;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    AutoCompleteTextView autoCompleteTextView;
    Button pokemonButton;
    ImageView pokemonImageView;
    TextView pokemonNameTextView;
    TextView pokemonTypeTextView;
    TextView pokemonHeightTextView;
    TextView pokemonWeightTextView;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Binding the variables with the UI Id's
        autoCompleteTextView = binding.autoCompleteTextViewPokemonName;
        pokemonButton = binding.goButton;
        pokemonImageView = binding.pokemonImage;
        pokemonNameTextView = binding.pokemonName;
        pokemonTypeTextView = binding.pokemonType;
        pokemonHeightTextView = binding.pokemonHeight;
        pokemonWeightTextView = binding.pokemonWeight;

        // Initialize AutoCompleteTextView arrayAdapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView.setAdapter(arrayAdapter);


        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // API call for Pokemon name suggestions based on user input
                callPokemonNameSuggestions(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Set up click listener for the "Go" button
        pokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedPokemonName = autoCompleteTextView.getText().toString();

                // Make an API request to fetch Pokemon details
                callPokemonDetails(selectedPokemonName);

                // Change the visibility of elements to visible
                pokemonImageView.setVisibility(View.VISIBLE);
                pokemonNameTextView.setVisibility(View.VISIBLE);
                pokemonTypeTextView.setVisibility(View.VISIBLE);
                pokemonHeightTextView.setVisibility(View.VISIBLE);
                pokemonWeightTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void callPokemonNameSuggestions (String userInputText) {
        // Make an API call to fetch Pokemon name suggestions based on the user input
        Call<PokemonListResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .getPokemonList(1500, 0);

        // Make the Api call
        call.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                if (response.isSuccessful()) {
                    PokemonListResponse listResponse = response.body();
                    List<PokemonListItem> pokemonItems = listResponse.getResults();
                    List<String> suggestions = new ArrayList<>();

                    // Iterate through the PokemonListItem objects and add their names to suggestions
                    for (PokemonListItem item : pokemonItems) {
                        suggestions.add(item.getName());
                    }

                    // Clear the adapter and add new suggestions
                    arrayAdapter.clear();
                    arrayAdapter.addAll(suggestions);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                System.out.println("Sorry there's an error in here");
            }
        });
    }

    public void updateUi(PokemonDetails pokemonDetails) {
        ImageView imageView = binding.pokemonImage;

        // Construct the image URL based on the Pokemon ID
        String imageUrl =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" +
                        pokemonDetails.getId() + ".png";

        // Load the Pokemon image using Glide
        Glide.with(this)
                .load(imageUrl)
                .into(imageView);

        // Set the Pokemon name
        TextView nameTextView = binding.pokemonName;
        nameTextView.setText(pokemonDetails.getName());

        TextView typesTextView = binding.pokemonType;
        // Extract and format types
        StringBuilder types = new StringBuilder("Types: ");
        for (PokemonType type : pokemonDetails.getTypes()) {
            types.append(type.getType().getName()).append(" - ");
        }
        types.setLength(types.length() - 3); // Remove the last hyphen and space
        typesTextView.setText(types.toString());

        // Set the Pokemon height and weight
        TextView heightTextView = binding.pokemonHeight;
        heightTextView.setText("Height: " + pokemonDetails.getHeight() + "ft");

        TextView weightTextView = binding.pokemonWeight;
        weightTextView.setText("Weight: " + pokemonDetails.getWeight() + "lbs");
    }
    private void callPokemonDetails(String selectedPokemonName){

        // Make an API request to fetch Pokemon details
        Call<PokemonDetails> call = RetrofitClient
                .getInstance()
                .getApi()
                .getPokemonDetails(selectedPokemonName);

        call.enqueue(new Callback<PokemonDetails>() {
            @Override
            public void onResponse(Call<PokemonDetails> call, Response<PokemonDetails> response) {
                if (response.isSuccessful()) {
                    // Handle the response and update the UI
                    PokemonDetails pokemonDetails = response.body();
                    if (pokemonDetails != null) {
                        // Call the updateUi method only if pokemonDetails is not null
                        updateUi(pokemonDetails);
                    } else {
                        System.out.println("Sorry there's an error in here");
                    }
                }
            }
            @Override
            public void onFailure(Call<PokemonDetails> call, Throwable t) {
                System.out.println("Sorry there's an error in here");
            }
        });
    }
}