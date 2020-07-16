package com.microservice_pokemon.controllers;

import com.microservice_pokemon.business.TypeBO;
import com.microservice_pokemon.data.transfer.object.TypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class TypeController {

    @Autowired
    private TypeBO bo;

    @GetMapping(value = "/type")
    public List<TypeDTO> findAll(){
        return bo.findAll();
    }
}
