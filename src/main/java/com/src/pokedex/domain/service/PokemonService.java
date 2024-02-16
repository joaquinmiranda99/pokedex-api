package com.src.pokedex.domain.service;

import com.src.pokedex.domain.model.PokemonDetailed;
import com.src.pokedex.domain.model.PokemonReducedInfo;
import com.src.pokedex.infra.*;
import com.src.pokedex.infra.pokeapi.PokeApiClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PokemonService {

    private final PokeApiClient client;

    public PokemonService(PokeApiClient client) {
        this.client = client;
    }

    public List<PokemonReducedInfo> getAll(long page) {
        GetListOfPokemonResponse response = client.getAllPokemons(page, 5);
        return mapToDomainPokemon(response.getResults());
    }

    private List<PokemonReducedInfo> mapToDomainPokemon(List<PokemonReduceDTO> pokemonsFromApi) {
        return pokemonsFromApi.stream().map(pokemonToSearchInfo -> {
            PokemonDTO pokemon = client.getPokemonById(pokemonToSearchInfo.getName());
            return createPokemonReduceInfoFrom(pokemon);
        }).toList();
    }

    private static PokemonReducedInfo createPokemonReduceInfoFrom(PokemonDTO pokemon) {
        List<String> types = pokemon.getTypes().stream().map(typeInfo -> typeInfo.getType().getName()).toList();
        List<String> abilities = pokemon.getAbilities().stream().map(abilityInfo -> abilityInfo.getAbility().getName()).toList();
        return new PokemonReducedInfo(pokemon.getName(), (String) pokemon.getSprites().get("back_default"), types, pokemon.getWeight(), abilities);
    }

    public PokemonDetailed getById(String id) {
        PokemonDTO pokemonFromApi = client.getPokemonById(id);
        PokemonReducedInfo pokemonReducedInfo = createPokemonReduceInfoFrom(pokemonFromApi);
        PokemonSpecies species = client.getPokemonSpecies(id);

        String description = getRandomFlavor(species);

        return new PokemonDetailed(
                pokemonReducedInfo,
                description,
                pokemonFromApi.getMoves()
                        .stream()
                        .map(move -> move.getMove().getName()).toList());
    }

    private String getRandomFlavor(PokemonSpecies species) {
        List<Flavor> flavors = species.getFlavors()
                .stream()
                .filter(flavor -> "es".equals(flavor.getLanguage().getName()))
                .toList();

        return flavors.get(new Random().nextInt(flavors.size())).getFlavorText();
    }
}
