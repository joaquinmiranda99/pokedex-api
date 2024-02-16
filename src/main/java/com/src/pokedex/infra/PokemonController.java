package com.src.pokedex.infra;

import com.src.pokedex.domain.service.PokemonService;
import com.src.pokedex.domain.model.PokemonDetailed;
import com.src.pokedex.domain.model.PokemonReducedInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public ResponseEntity<List<PokemonReducedInfo>> getAllPokemons(@RequestParam("page") long page) {
        List<PokemonReducedInfo> careers = pokemonService.getAll(page);
        return new ResponseEntity<>(careers, HttpStatus.OK);
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonDetailed> getCarreraById(@PathVariable String id) {
        PokemonDetailed career = pokemonService.getById(id);
        return new ResponseEntity<>(career, HttpStatus.OK);
    }

}
