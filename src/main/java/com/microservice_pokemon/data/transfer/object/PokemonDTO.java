package com.microservice_pokemon.data.transfer.object;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PokemonDTO {
    private int id;
    private String name;
    private String image;
    private String type1;
    private String type2;
    private double height;
    private double weight;
    private List<PokemonDTO> previousEvolutions;
    private List<PokemonDTO> nextEvolutions;
    private List<CapacityDTO> capacities;
    private List<TalentDTO> talents;
    private StatisticDTO statistics;
    private Integer levelEvolution;
    private String conditionEvolution;
    private List<WeaknessDTO> weaknesses;
}
