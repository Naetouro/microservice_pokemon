package com.microservice_pokemon.data.interfaces;

import java.util.List;

public interface CustomPokemon {
    int getId();
    String getName();
    List<CustomType> getTypes();
    String getImage();
}
