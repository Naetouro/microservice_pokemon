package com.microservice_pokemon.data.transfer.object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WeaknessDTO {
    private String typeName;
    private double multiple;
}
