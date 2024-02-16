package com.src.pokedex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class PokemonDetailed {
    private PokemonReducedInfo info;
    private String description;
    private List<String> moves;

    public PokemonDetailed(PokemonReducedInfo info, String description, List<String> moves) {
        this.info = info;
        this.description = description;
        this.moves = moves;
    }
}
