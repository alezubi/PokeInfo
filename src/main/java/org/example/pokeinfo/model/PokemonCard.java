package org.example.pokeinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonCard {
    private String id;
    private String name;
    private String hp;
    private List<String> types;
    private String rarity;
    private PokemonSet set;
    private PokemonImage images;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHp() { return hp; }
    public void setHp(String hp) { this.hp = hp; }

    public List<String> getTypes() { return types; }
    public void setTypes(List<String> types) { this.types = types; }

    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }

    public PokemonSet getSet() { return set; }
    public void setSet(PokemonSet set) { this.set = set; }

    public PokemonImage getImages() { return images; }
    public void setImages(PokemonImage images) { this.images = images; }

    @Override
    public String toString() {
        return "PokemonCard{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", types=" + types +
                ", rarity='" + rarity + '\'' +
                ", set=" + set +
                ", images=" + images +
                '}';
    }
}
