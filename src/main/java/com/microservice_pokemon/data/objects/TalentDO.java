package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.microservice_pokemon.data.superclasses.Common;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "talents", schema = "", catalog = "")
public class TalentDO extends Common {
    private String description;
    private List<PokemonDO> pokemons;

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "talents", fetch = FetchType.LAZY)
    @JsonBackReference
    public List<PokemonDO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonDO> pokemons) {
        this.pokemons = pokemons;
    }
}
