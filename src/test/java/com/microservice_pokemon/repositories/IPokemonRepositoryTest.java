package com.microservice_pokemon.repositories;

import com.microservice_pokemon.data.interfaces.CustomPokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class IPokemonRepositoryTest {

    @Autowired
    private IPokemonRepository repo;

    @Test
    void findById() {
    }

    @Test
    void findAllWithType() {
        final Pageable pageable = PageRequest.of(0, 5);
        List<CustomPokemon> pokemonList = repo.findAllWithType(pageable);

        assertEquals("bulbizarre", pokemonList.get(0).getName());
        assertEquals("herbizarre", pokemonList.get(1).getName());
        assertEquals("florizarre", pokemonList.get(2).getName());
    }

    @Test
    void findAllByNameLike() {
        final Pageable pageable = PageRequest.of(0, 5);
        List<CustomPokemon> pokemonList = repo.findAllByNameLike("bulbizarre",pageable);

        assertEquals("bulbizarre", pokemonList.get(0).getName());
    }

    @Test
    void countAllByNameLike() {
        long count = repo.countAllByNameLike("bulbizarre");
        long count2 = repo.countAllByNameLike("zar");

        assertEquals(1, count);
        assertEquals(3, count2);
    }

    @Test
    void findDistinctByTypesIn() {
    }

    @Test
    void countDistinctByTypesIn() {
    }

    @Test
    void findAllName() {
    }
}