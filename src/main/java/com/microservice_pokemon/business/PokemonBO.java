package com.microservice_pokemon.business;

import com.microservice_pokemon.custom.exceptions.ResourceNotFoundException;
import com.microservice_pokemon.data.interfaces.CustomPokemon;
import com.microservice_pokemon.data.objects.PokemonDO;
import com.microservice_pokemon.data.objects.TypeDO;
import com.microservice_pokemon.data.transfer.object.PokemonDTO;
import com.microservice_pokemon.repositories.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author quentin
 */
@Service
public class PokemonBO {

    @Autowired
    private IPokemonRepository repo;
    @Autowired
    private Utils utils;

    /**
     * @return PokemonDTO list
     * @throws IOException
     */
    public List<PokemonDTO> findAllWithType(final int page, final int number) throws IOException{
        final Pageable pageable = PageRequest.of(page, number);
        final List<CustomPokemon> listCustom = repo.findAllWithType(pageable);

        return utils.customToDTO(listCustom);
    }

    /**
     * @param id int
     * @return PokemonDTO
     * @throws IOException
     */
    public PokemonDTO findById(final int id) throws IOException, ResourceNotFoundException{
        final PokemonDO pokemonDO = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found for id : " + id));
        final PokemonDTO pokemonDTO = new PokemonDTO();

        utils.setBasicAttributes(pokemonDO, pokemonDTO);
        utils.setTalents(pokemonDO, pokemonDTO);
        utils.setCapacities(pokemonDO, pokemonDTO);
        utils.setStatistics(pokemonDO, pokemonDTO);
        utils.setEvolutions(pokemonDO, pokemonDTO, "next");
        utils.setEvolutions(pokemonDO, pokemonDTO, "previous");
        utils.setWeaknesses(pokemonDO, pokemonDTO);

        return pokemonDTO;
    }

    public List<PokemonDTO> findAllByTypesIn(final List<Integer> typeIds, final int page, final int number) throws IOException {
        final Pageable pageable = PageRequest.of(page, number);
        final List<TypeDO> types = utils.setListTypes(typeIds);
        final List<CustomPokemon> customPokemons = repo.findDistinctByTypesIn(types, pageable);

        return utils.customToDTO(customPokemons);
    }

    public List<PokemonDTO> findAllByNameLike(final String name, final int page, final int number) throws IOException {
        final Pageable pageable = PageRequest.of(page, number);
        final List<CustomPokemon> listCustom = repo.findAllByNameLike(name, pageable);

        return utils.customToDTO(listCustom);
    }

    public List<String> findAllName(){
        return repo.findAllName();
    }

    public long count(){
        return repo.count();
    }

    public long countDistinctByTypesIn(final List<Integer> typeIds){
        final List<TypeDO> types = utils.setListTypes(typeIds);
        return repo.countDistinctByTypesIn(types);
    }

    public long countAllByNameLike(final String name){
        return repo.countAllByNameLike(name);
    }
}
