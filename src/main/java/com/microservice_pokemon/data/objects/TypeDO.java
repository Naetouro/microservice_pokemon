package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.*;
import com.microservice_pokemon.data.superclasses.Common;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types", schema = "", catalog = "")
public class TypeDO{
    private List<WeaknesseDO> weaknesses;
    private List<PokemonDO> pokemons;
    private List<CapacityDO> capacities;
    private Integer id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "type")
    @JsonBackReference
    public List<WeaknesseDO> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<WeaknesseDO> weaknessesById) {
        this.weaknesses = weaknessesById;
    }

    @ManyToMany(mappedBy = "types", fetch = FetchType.LAZY)
    @JsonBackReference
    public List<PokemonDO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonDO> pokemons) {
        this.pokemons = pokemons;
    }

    @OneToMany(mappedBy = "type")
    public List<CapacityDO> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<CapacityDO> capacities) {
        this.capacities = capacities;
    }
}
