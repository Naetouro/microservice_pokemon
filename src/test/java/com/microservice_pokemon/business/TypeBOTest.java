package com.microservice_pokemon.business;

import com.microservice_pokemon.data.transfer.object.TypeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class TypeBOTest {

    @Autowired
    private TypeBO bo;

    @Test
    void findAll() {
        final List<TypeDTO> typeDTOS = bo.findAll();

        assertEquals(17, typeDTOS.size());
    }
}