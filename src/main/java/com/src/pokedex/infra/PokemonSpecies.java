package com.src.pokedex.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PokemonSpecies {
    @JsonProperty("flavor_text_entries")
    private List<Flavor> flavors;
}
