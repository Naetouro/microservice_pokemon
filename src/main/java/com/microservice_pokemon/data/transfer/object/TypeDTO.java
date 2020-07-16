package com.microservice_pokemon.data.transfer.object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TypeDTO {
    private int id;
    private String name;

    public TypeDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
