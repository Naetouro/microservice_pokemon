package com.microservice_pokemon.data.objects;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PokemonCapacitiesDOPK implements Serializable {
    private Integer idCapacity;
    private Integer idPokemon;

    @Column(name = "id_capacity", nullable = false)
    @Id
    public Integer getIdCapacity() {
        return idCapacity;
    }

    public void setIdCapacity(Integer idCapacity) {
        this.idCapacity = idCapacity;
    }

    @Column(name = "id_pokemon", nullable = false)
    @Id
    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }
}
