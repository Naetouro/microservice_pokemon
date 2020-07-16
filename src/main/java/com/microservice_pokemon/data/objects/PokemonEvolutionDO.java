package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_evolutions", schema = "", catalog = "")
@IdClass(PokemonEvolutionDOPK.class)
public class PokemonEvolutionDO {
    private Integer idPok1;
    private Integer idPok2;
    private PokemonDO pokemon2;
    private PokemonDO pokemon1;

    @Id
    @Column(name = "id_pok1", nullable = false)
    public Integer getIdPok1() {
        return idPok1;
    }

    public void setIdPok1(Integer idPok1) {
        this.idPok1 = idPok1;
    }

    @Id
    @Column(name = "id_pok2", nullable = false)
    public Integer getIdPok2() {
        return idPok2;
    }

    public void setIdPok2(Integer idPok2) {
        this.idPok2 = idPok2;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pok2", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public PokemonDO getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(PokemonDO pokemonsByIdPok1) {
        this.pokemon2 = pokemonsByIdPok1;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pok1", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public PokemonDO getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(PokemonDO pokemonsByIdPok2) {
        this.pokemon1 = pokemonsByIdPok2;
    }
}
