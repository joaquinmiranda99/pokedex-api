package com.src.pokedex.infra;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class PokemonDTO {
    private String name;
    private List<TypeDTO> types;
    private int weight;
    private List<AbilityInfoDTO> abilities;
    private Map<String, Object> sprites;
    private List<MovementInfo> moves;
}
