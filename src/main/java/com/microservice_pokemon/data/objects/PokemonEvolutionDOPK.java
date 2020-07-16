package com.microservice_pokemon.data.objects;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PokemonEvolutionDOPK implements Serializable {
    private Integer idPok1;
    private Integer idPok2;

    @Column(name = "id_pok1", nullable = false)
    @Id
    public Integer getIdPok1() {
        return idPok1;
    }

    public void setIdPok1(Integer idPok1) {
        this.idPok1 = idPok1;
    }

    @Column(name = "id_pok2", nullable = false)
    @Id
    public Integer getIdPok2() {
        return idPok2;
    }

    public void setIdPok2(Integer idPok2) {
        this.idPok2 = idPok2;
    }
}
