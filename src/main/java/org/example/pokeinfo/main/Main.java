package org.example.pokeinfo.main;

import org.example.pokeinfo.model.PokemonCard;
import org.example.pokeinfo.service.PokemonAPIService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pokemonName = "Charizard"; // Change this to search for a different Pokémon
        List<PokemonCard> cards = PokemonAPIService.fetchPokemonCardByName(pokemonName);

        if (cards.isEmpty()) {
            System.out.println("No Pokémon cards found for: " + pokemonName);
        } else {
            for (PokemonCard card : cards) {
                System.out.println("\n--- Pokémon Card Found ---");
                System.out.println("Name: " + card.getName());
                System.out.println("HP: " + card.getHp());
                System.out.println("Types: " + card.getTypes());
                System.out.println("Rarity: " + card.getRarity());
                System.out.println("Set: " + card.getSet());
                System.out.println("Image: " + card.getImages().getLarge());
            }
        }
    }
}
