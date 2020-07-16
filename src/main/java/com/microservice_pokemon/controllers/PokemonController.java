package com.microservice_pokemon.controllers;

import com.microservice_pokemon.business.PokemonBO;
import com.microservice_pokemon.custom.exceptions.ResourceNotFoundException;
import com.microservice_pokemon.data.transfer.object.PokemonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PokemonController {

    @Autowired
    private PokemonBO bo;

    @GetMapping(value = "/pokemon/name")
    public List<PokemonDTO> findAllByNameLike(@RequestParam final String name, @RequestParam final int page, @RequestParam final int number) throws IOException {
        return bo.findAllByNameLike(name, page, number);
    }

    @GetMapping(value = "/pokemon/filter")
    public List<PokemonDTO> findAllByTypesIn(@RequestParam final List<Integer> typeIds, @RequestParam final int page, @RequestParam final int number) throws IOException{
        return bo.findAllByTypesIn(typeIds, page, number);
    }

    @GetMapping(value = "/pokemon")
    public List<PokemonDTO> findAll(@RequestParam final int page, @RequestParam final int number) throws IOException {
        return bo.findAllWithType(page, number);
    }

    @GetMapping(value = "/pokemon/{id}")
    public PokemonDTO findById(@PathVariable final int id) throws IOException, ResourceNotFoundException{
        return bo.findById(id);
    }

    @GetMapping(value = "/pokemon/count")
    public long count() {
        return bo.count();
    }

    @GetMapping(value = "/pokemon/filter/count")
    public long countFilter(@RequestParam final List<Integer> typeIds) {
        return bo.countDistinctByTypesIn(typeIds);
    }

    @GetMapping(value = "/pokemon/name/count")
    public long countAllByNameLike(@RequestParam final String name) {
        return bo.countAllByNameLike(name);
    }

    @GetMapping(value = "/pokemon/names")
    public List<String> findAllName() {
        return bo.findAllName();
    }
}
