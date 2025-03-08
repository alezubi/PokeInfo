package org.example.pokeinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonImage {
    private String small;
    private String large;

    public String getSmall() { return small; }
    public void setSmall(String small) { this.small = small; }

    public String getLarge() { return large; }
    public void setLarge(String large) { this.large = large; }

    @Override
    public String toString() {
        return "Image URL: " + large;
    }
}
