package com.src.pokedex.infra.pokeapi;

import com.src.pokedex.infra.GetListOfPokemonResponse;
import com.src.pokedex.infra.PokemonDTO;
import com.src.pokedex.infra.PokemonSpecies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "pokemon", url = "${pokemon.api.url}")
public interface PokeApiClient {
    @RequestMapping(method = RequestMethod.GET, value = "pokemon/{pokemonId}")
    PokemonDTO getPokemonById(
            @PathVariable("pokemonId") String pokemonId
    );

    @RequestMapping(method = RequestMethod.GET, value = "pokemon-species/{pokemonId}")
    PokemonSpecies getPokemonSpecies(
            @PathVariable("pokemonId") String pokemonId
    );

    @RequestMapping(method = RequestMethod.GET, value = "pokemon")
    GetListOfPokemonResponse getAllPokemons(
            @RequestParam("offset") long offset,
            @RequestParam("limit") long limit
    );

}
