package com.microservice_pokemon.business;

import com.microservice_pokemon.custom.exceptions.ResourceNotFoundException;
import com.microservice_pokemon.data.transfer.object.PokemonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class PokemonBOTest {

    @Autowired
    private PokemonBO bo;

    @Test
    void findAllWithType() throws IOException {
        List<PokemonDTO> pokemonDTOS = bo.findAllWithType(0, 3);

        assertEquals("bulbizarre", pokemonDTOS.get(0).getName());
        assertEquals("herbizarre", pokemonDTOS.get(1).getName());
        assertEquals("florizarre", pokemonDTOS.get(2).getName());
    }

    @Test
    void countAllByNameLike() {
        long bulbizarre = bo.countAllByNameLike("bulbizarre");
        long zar = bo.countAllByNameLike("zar");

        assertEquals(1, bulbizarre);
        assertEquals(3, zar);
    }

    @Test
    void findById() throws IOException, ResourceNotFoundException, URISyntaxException {
        PokemonDTO pokemonDTO = bo.findById(1);
        assertEquals(1, pokemonDTO.getId());
        assertEquals("bulbizarre", pokemonDTO.getName());
        assertEquals("plante", pokemonDTO.getType1());
        assertEquals("poison", pokemonDTO.getType2());
    }

    @Test
    void findAllByTypesIn() throws IOException {
        List<Integer> typeDOS = new ArrayList<>();
        typeDOS.add(1);
        typeDOS.add(2);
        typeDOS.add(4);

        List<PokemonDTO> pokemonDTOS = bo.findAllByTypesIn(typeDOS, 0, 5);

        assertEquals("bulbizarre", pokemonDTOS.get(0).getName());
        assertEquals("herbizarre", pokemonDTOS.get(1).getName());
        assertEquals("florizarre", pokemonDTOS.get(2).getName());
        assertEquals("evoli", pokemonDTOS.get(3).getName());
    }

    @Test
    void findAllByNameLike() throws IOException {
        List<PokemonDTO> pokemonDTOS = bo.findAllByNameLike("bulbizarre", 0, 5);
        List<PokemonDTO> pokemonDTOS2 = bo.findAllByNameLike("zar", 0, 5);

        assertEquals("bulbizarre", pokemonDTOS.get(0).getName());
        assertEquals("bulbizarre", pokemonDTOS2.get(0).getName());
        assertEquals("herbizarre", pokemonDTOS2.get(1).getName());
        assertEquals("florizarre", pokemonDTOS2.get(2).getName());
    }

    @Test
    void findAllName() {
        List<String> list = bo.findAllName();
        assertTrue(list.size() > 0);
    }

    @Test
    void count() {
        long count = bo.count();
        assertTrue(count > 0);
    }

    @Test
    void countDistinctByTypesIn() {
        List<Integer> typeDOS = new ArrayList<>();
        typeDOS.add(1);
        typeDOS.add(2);
        typeDOS.add(4);

        long count = bo.countDistinctByTypesIn(typeDOS);

        assertEquals(4, count);
    }
}