package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_capacities", schema = "", catalog = "")
@IdClass(PokemonCapacitiesDOPK.class)
public class PokemonCapacitiesDO {
    private Integer idCapacity;
    private Integer idPokemon;
    private Integer level;
    private CapacityDO capacity;
    private PokemonDO pokemon;

    @Id
    @Column(name = "id_capacity", nullable = false)
    public Integer getIdCapacity() {
        return idCapacity;
    }

    public void setIdCapacity(Integer idCapacity) {
        this.idCapacity = idCapacity;
    }

    @Id
    @Column(name = "id_pokemon", nullable = false)
    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    @Basic
    @Column(name = "level", nullable = true)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @ManyToOne
    @JoinColumn(name = "id_capacity", referencedColumnName = "id", nullable = false , insertable = false, updatable = false)
    @JsonManagedReference
    public CapacityDO getCapacity() {
        return capacity;
    }

    public void setCapacity(CapacityDO capacitiesByIdCapacity) {
        this.capacity = capacitiesByIdCapacity;
    }

    @ManyToOne
    @JoinColumn(name = "id_pokemon", referencedColumnName = "id", nullable = false , insertable = false, updatable = false)
    @JsonBackReference
    public PokemonDO getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonDO pokemonsByIdPokemon) {
        this.pokemon = pokemonsByIdPokemon;
    }
}
