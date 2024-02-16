package com.src.pokedex.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Flavor {
    @JsonProperty("flavor_text")
    private String flavorText;

    private Language language;
}
