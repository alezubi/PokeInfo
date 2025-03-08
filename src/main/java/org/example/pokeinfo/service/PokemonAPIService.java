package org.example.pokeinfo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pokeinfo.model.PokemonCard;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonAPIService {
    private static final String API_URL = "https://api.pokemontcg.io/v2/cards?q=name:";
    private static final OkHttpClient client = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<PokemonCard> fetchPokemonCardByName(String name) {
        List<PokemonCard> pokemonCards = new ArrayList<>();
        String requestUrl = API_URL + name;

        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("X-Api-Key", "YOUR_API_KEY")  // Replace with your API key if required
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Error: " + response.code());
                return pokemonCards;
            }

            // Parse JSON response
            String jsonResponse = response.body().string();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode dataNode = rootNode.get("data");

            if (dataNode != null) {
                for (JsonNode node : dataNode) {
                    PokemonCard card = objectMapper.treeToValue(node, PokemonCard.class);
                    pokemonCards.add(card);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return pokemonCards;
    }
}
