package com.microservice_pokemon.repositories;

import com.microservice_pokemon.data.interfaces.CustomPokemon;
import com.microservice_pokemon.data.objects.PokemonDO;
import com.microservice_pokemon.data.objects.TypeDO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPokemonRepository extends JpaRepository<PokemonDO, Integer> {

    @Transactional
    @Query(value = "select p from PokemonDO p where p.id = :id")
    Optional<PokemonDO> findById(final int id);

    @Query(value = "select p from PokemonDO p")
    List<CustomPokemon> findAllWithType(Pageable pageable);
    @Query("select p from PokemonDO p where p.name like %:name% ")
    List<CustomPokemon> findAllByNameLike(String name, Pageable pageable);
    @Query("select count(p.id) from PokemonDO p where p.name like %:name% ")
    long countAllByNameLike(String name);
    List<CustomPokemon> findDistinctByTypesIn(List<TypeDO> types, Pageable pageable);
    long countDistinctByTypesIn(List<TypeDO> types);
    @Query("select p.name from PokemonDO p")
    List<String> findAllName();

}
