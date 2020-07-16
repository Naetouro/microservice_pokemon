package com.microservice_pokemon.data.objects;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class WeaknesseDOPK implements Serializable {
    private Integer idType;
    private Integer idPokemon;

    @Column(name = "id_type", nullable = false)
    @Id
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
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
