package com.src.pokedex.infra;

import lombok.Data;

import java.util.List;

@Data
public class GetListOfPokemonResponse {
    private List<PokemonReduceDTO> results;
}
