package com.microservice_pokemon.data.objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.microservice_pokemon.data.superclasses.Common;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemons", schema = "", catalog = "")
public class PokemonDO extends Common {
    private Double height;
    private Double weight;
    private String image;
    private Integer levelEvolution;
    private String conditionEvolution;
    private List<PokemonCapacitiesDO> pokemonCapacities;
    private List<TalentDO> talents;
    private StatisticsDO statistics;
    private List<WeaknesseDO> weaknesses;
    private List<TypeDO> types;
    private List<PokemonEvolutionDO> previousEvolutions;
    private List<PokemonEvolutionDO> nextEvolutions;

    public PokemonDO(){}

    public PokemonDO(int id, String name){
        this.id = id;
        this.name = name;
    }

    public PokemonDO(String name){
        this.name = name;
    }

    @Basic
    @Column(name = "height", nullable = true, precision = 0)
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 500)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "level_evolution", nullable = true)
    public Integer getLevelEvolution() {
        return levelEvolution;
    }

    public void setLevelEvolution(Integer level) {
        this.levelEvolution = level;
    }

    @Basic
    @Column(name = "condition_evolution", nullable = true, length = 500)
    public String getConditionEvolution() {
        return conditionEvolution;
    }

    public void setConditionEvolution(String conditionEvolution) {
        this.conditionEvolution = conditionEvolution;
    }

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<PokemonCapacitiesDO> getPokemonCapacities() {
        return pokemonCapacities;
    }

    public void setPokemonCapacities(List<PokemonCapacitiesDO> pokemonCapacitiesById) {
        this.pokemonCapacities = pokemonCapacitiesById;
    }

    @ManyToMany
    @JoinTable(name = "pokemon_talents", catalog = "", schema = "", joinColumns = @JoinColumn(name = "id_pokemon", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_talent", referencedColumnName = "id", nullable = false))
    @JsonManagedReference
    public List<TalentDO> getTalents() {
        return talents;
    }

    public void setTalents(List<TalentDO> talents) {
        this.talents = talents;
    }

    @ManyToMany
    @JoinTable(name = "pokemon_types", catalog = "", schema = "", joinColumns = @JoinColumn(name = "id_pokemon", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false))
    @JsonManagedReference
    public List<TypeDO> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDO> types) {
        this.types = types;
    }

    @OneToOne(mappedBy = "pokemon", fetch = FetchType.LAZY)
    @JsonManagedReference
    public StatisticsDO getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsDO statisticsById) {
        this.statistics = statisticsById;
    }

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<WeaknesseDO> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<WeaknesseDO> weaknessesById) {
        this.weaknesses = weaknessesById;
    }

    @OneToMany(mappedBy = "pokemon2", fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<PokemonEvolutionDO> getPreviousEvolutions() {
        return previousEvolutions;
    }

    public void setPreviousEvolutions(List<PokemonEvolutionDO> pokemonEvolutionsById) {
        this.previousEvolutions = pokemonEvolutionsById;
    }

    @OneToMany(mappedBy = "pokemon1", fetch = FetchType.LAZY)
    @JsonManagedReference
    public List<PokemonEvolutionDO> getNextEvolutions() {
        return nextEvolutions;
    }

    public void setNextEvolutions(List<PokemonEvolutionDO> pokemonEvolution2) {
        this.nextEvolutions = pokemonEvolution2;
    }

}
