package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "statistics", schema = "", catalog = "")
public class StatisticsDO {
    private Integer id;
    private Integer pv;
    private Integer attack;
    private Integer defense;
    private Integer specialAttack;
    private Integer specialDefense;
    private Integer speed;
    private PokemonDO pokemon;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pv", nullable = true)
    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    @Basic
    @Column(name = "attack", nullable = true)
    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @Basic
    @Column(name = "defense", nullable = true)
    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    @Basic
    @Column(name = "special_attack", nullable = true)
    public Integer getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    @Basic
    @Column(name = "special_defense", nullable = true)
    public Integer getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(Integer specialDefense) {
        this.specialDefense = specialDefense;
    }

    @Basic
    @Column(name = "speed", nullable = true)
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer vitesse) {
        this.speed = vitesse;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pokemon", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    public PokemonDO getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonDO pokemonsByIdPokemon) {
        this.pokemon = pokemonsByIdPokemon;
    }
}
