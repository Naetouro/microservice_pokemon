package com.microservice_pokemon.data.transfer.object;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StatisticDTO {
    private int pv;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
}
