package com.src.pokedex.domain.model;

import lombok.*;

import java.util.List;

@Data
public class PokemonReducedInfo {
    private String name;
    private String photoUrl;
    private List<String> types;
    private int weight;
    private List<String> abilities;

    public PokemonReducedInfo(String name, String photoUrl, List<String> types, int weight, List<String> abilities) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.types = types;
        this.weight = weight;
        this.abilities = abilities;
    }
}
