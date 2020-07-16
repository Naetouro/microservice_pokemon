package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.microservice_pokemon.data.superclasses.Common;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "capacities", schema = "", catalog = "")
public class CapacityDO extends Common {
    private Integer damage;
    private Collection<PokemonCapacitiesDO> pokemonCapacities;
    private TypeDO type;

    @Basic
    @Column(name = "damage", nullable = true)
    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    @OneToMany(mappedBy = "capacity")
    @JsonBackReference
    public Collection<PokemonCapacitiesDO> getPokemonCapacities() {
        return pokemonCapacities;
    }

    public void setPokemonCapacities(Collection<PokemonCapacitiesDO> pokemonCapacitiesById) {
        this.pokemonCapacities = pokemonCapacitiesById;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public TypeDO getType() {
        return type;
    }

    public void setType(TypeDO type) {
        this.type = type;
    }
}
