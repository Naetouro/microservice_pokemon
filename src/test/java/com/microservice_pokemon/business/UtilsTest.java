package com.microservice_pokemon.business;

import com.microservice_pokemon.data.objects.PokemonDO;
import com.microservice_pokemon.data.objects.TypeDO;
import com.microservice_pokemon.data.transfer.object.PokemonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UtilsTest {

    @Autowired
    private Utils utils;

    @Test
    void setBasicAttributes() throws IOException{
        PokemonDO pokemonDO = new PokemonDO();
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDO.setId(1);
        pokemonDO.setName("test");
        pokemonDO.setHeight(1.0);
        pokemonDO.setWeight(1.0);
        pokemonDO.setLevelEvolution(1);
        pokemonDO.setConditionEvolution(null);
        TypeDO typeDO1 = new TypeDO();
        typeDO1.setName("test1");
        TypeDO typeDO2 = new TypeDO();
        typeDO2.setName("test2");
        List<TypeDO> typeDOS = new ArrayList<>();
        typeDOS.add(typeDO1);
        typeDOS.add(typeDO2);
        pokemonDO.setTypes(typeDOS);
        pokemonDO.setImage("bulbizarre.png");

        utils.setBasicAttributes(pokemonDO, pokemonDTO);
        assertEquals(1, pokemonDTO.getId());
        assertEquals("test", pokemonDTO.getName());
        assertEquals("test1", pokemonDTO.getType1());

    }

    @Test
    void setImage() {
    }

    @Test
    void setTalents() {
    }

    @Test
    void setCapacities() {
    }

    @Test
    void setStatistics() {
    }

    @Test
    void setEvolutions() {
    }

    @Test
    void setIdNameLevelCondition() {
    }

    @Test
    void switchEvolution() {
    }

    @Test
    void setWeaknesses() {
    }

    @Test
    void setListTypes() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        List<TypeDO> typeDOS = utils.setListTypes(ints);

        assertEquals(1, typeDOS.get(0).getId());
        assertEquals(2, typeDOS.get(1).getId());
    }

    @Test
    void customToDTO() {
    }
}