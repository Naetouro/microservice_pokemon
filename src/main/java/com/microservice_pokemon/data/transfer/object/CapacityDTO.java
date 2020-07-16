package com.microservice_pokemon.data.transfer.object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CapacityDTO {
    private String name;
    private int damage;
    private int level;
    private TypeDTO type;
}
