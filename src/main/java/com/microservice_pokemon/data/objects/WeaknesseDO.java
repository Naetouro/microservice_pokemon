package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "weaknesses", schema = "", catalog = "")
@IdClass(WeaknesseDOPK.class)
public class WeaknesseDO {
    private Integer idType;
    private Integer idPokemon;
    private Double multiple;
    private TypeDO type;
    private PokemonDO pokemon;

    @Id
    @Column(name = "id_type", nullable = false)
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
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
    @Column(name = "multiple", nullable = true, precision = 0)
    public Double getMultiple() {
        return multiple;
    }

    public void setMultiple(Double multiple) {
        this.multiple = multiple;
    }

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonManagedReference
    public TypeDO getType() {
        return type;
    }

    public void setType(TypeDO typesByIdType) {
        this.type = typesByIdType;
    }

    @ManyToOne
    @JoinColumn(name = "id_pokemon", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public PokemonDO getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonDO pokemonsByIdPokemon) {
        this.pokemon = pokemonsByIdPokemon;
    }
}
