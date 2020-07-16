package com.microservice_pokemon.business;

import com.microservice_pokemon.data.interfaces.CustomPokemon;
import com.microservice_pokemon.data.objects.*;
import com.microservice_pokemon.data.transfer.object.*;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;

@Service
class Utils {

    @Autowired
    private ResourceLoader rl;

    void setBasicAttributes(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO) throws IOException {
        pokemonDTO.setId(pokemonDO.getId());
        pokemonDTO.setName(pokemonDO.getName());
        pokemonDTO.setHeight(pokemonDO.getHeight());
        pokemonDTO.setWeight(pokemonDO.getWeight());
        pokemonDTO.setLevelEvolution(pokemonDO.getLevelEvolution());
        pokemonDTO.setConditionEvolution(pokemonDO.getConditionEvolution());
        pokemonDTO.setType1(pokemonDO.getTypes().get(0).getName());

        if (pokemonDO.getTypes().size() == 2) {
            pokemonDTO.setType2(pokemonDO.getTypes().get(1).getName());
        }

        setImage(pokemonDO.getImage(), pokemonDTO);
    }

    void setImage(final String image, PokemonDTO pokemonDTO) throws IOException {
        ClassPathResource cpr = new ClassPathResource("static/images/"+image);
        if (cpr.exists()) {
            byte[] fileContent = FileUtil.readAsByteArray(cpr.getInputStream());
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            pokemonDTO.setImage(encodedString);
        }
    }

    void setTalents(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO) {
        final List<TalentDO> talentDOS = pokemonDO.getTalents();
        final List<TalentDTO> talentDTOS = new ArrayList<>();

        for (TalentDO talent : talentDOS) {
            final TalentDTO talentDTO = new TalentDTO();
            talentDTO.setName(talent.getName());
            talentDTO.setDescription(talent.getDescription());
            talentDTOS.add(talentDTO);
        }

        pokemonDTO.setTalents(talentDTOS);
    }

    void setCapacities(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO) {
        final List<PokemonCapacitiesDO> capacityDOS = pokemonDO.getPokemonCapacities();
        final List<CapacityDTO> capacityDTOS = new ArrayList<>();

        for (PokemonCapacitiesDO pokemonCapacitiesDO : capacityDOS) {
            final CapacityDTO capacityDTO = new CapacityDTO();
            final TypeDO typeCapacity = pokemonCapacitiesDO.getCapacity().getType();
            final TypeDTO typeDTO = new TypeDTO(typeCapacity.getId(), typeCapacity.getName());
            capacityDTO.setType(typeDTO);
            capacityDTO.setDamage(pokemonCapacitiesDO.getCapacity().getDamage());
            capacityDTO.setLevel(pokemonCapacitiesDO.getLevel());
            capacityDTO.setName(pokemonCapacitiesDO.getCapacity().getName());
            capacityDTOS.add(capacityDTO);
        }

        pokemonDTO.setCapacities(capacityDTOS);
    }

    void setStatistics(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO) {
        final StatisticDTO statisticDTO = new StatisticDTO();

        statisticDTO.setAttack(pokemonDO.getStatistics().getAttack());
        statisticDTO.setDefense(pokemonDO.getStatistics().getDefense());
        statisticDTO.setPv(pokemonDO.getStatistics().getPv());
        statisticDTO.setSpecialAttack(pokemonDO.getStatistics().getSpecialAttack());
        statisticDTO.setSpecialDefense(pokemonDO.getStatistics().getSpecialDefense());
        statisticDTO.setSpeed(pokemonDO.getStatistics().getSpeed());

        pokemonDTO.setStatistics(statisticDTO);
    }

    void setEvolutions(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO, final String choice) throws IOException {
        final List<PokemonDTO> evolutionsDTOS = new ArrayList<>();
        final List<PokemonEvolutionDO> pokemonEvolutionsDOS = choice.equals("next") ? pokemonDO.getNextEvolutions() : pokemonDO.getPreviousEvolutions();

        if (!pokemonEvolutionsDOS.isEmpty()) {
            for (PokemonEvolutionDO pokemonEvolutionDO : pokemonEvolutionsDOS) {
                final PokemonDTO pokemonDTO1 = new PokemonDTO();
                final PokemonDO pokemonDO1 = choice.equals("next") ? pokemonEvolutionDO.getPokemon2() : pokemonEvolutionDO.getPokemon1();

                setIdNameLevelCondition(pokemonDO1, pokemonDTO1);
                setImage(pokemonDO1.getImage(), pokemonDTO1);

                evolutionsDTOS.add(pokemonDTO1);

                setEvolutionOfEvolution(pokemonDO1, choice, evolutionsDTOS);
            }

            sortEvolutions(evolutionsDTOS);
        }

        if (choice.equals("next")) {
            pokemonDTO.setNextEvolutions(evolutionsDTOS);
        } else {
            pokemonDTO.setPreviousEvolutions(evolutionsDTOS);
        }
    }

    void setEvolutionOfEvolution(final PokemonDO pokemonDO, final String choice, List<PokemonDTO> evolutionsDTOS) throws IOException {
        final List<PokemonEvolutionDO> pokemonEvolutionOfEvolutionDOS = choice.equals("next") ? pokemonDO.getNextEvolutions() : pokemonDO.getPreviousEvolutions();

        if(!pokemonEvolutionOfEvolutionDOS.isEmpty()){
            for(PokemonEvolutionDO pokemonEvolutionDO1 : pokemonEvolutionOfEvolutionDOS){
                final PokemonDO pokemonDO2 = choice.equals("next") ? pokemonEvolutionDO1.getPokemon2() : pokemonEvolutionDO1.getPokemon1();

                final PokemonDTO pokemonDTO2 = new PokemonDTO();

                setIdNameLevelCondition(pokemonDO2, pokemonDTO2);
                setImage(pokemonDO2.getImage(), pokemonDTO2);

                evolutionsDTOS.add(pokemonDTO2);
            }
        }
    }

    void setIdNameLevelCondition(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO) {
        pokemonDTO.setId(pokemonDO.getId());
        pokemonDTO.setName(pokemonDO.getName());
        pokemonDTO.setLevelEvolution(pokemonDO.getLevelEvolution());
        pokemonDTO.setConditionEvolution(pokemonDO.getConditionEvolution());
    }

    void sortEvolutions(List<PokemonDTO> evolutionsDTOS) {
        evolutionsDTOS.sort(Comparator.comparing(PokemonDTO::getId));
    }

    void setWeaknesses(final PokemonDO pokemonDO, final PokemonDTO pokemonDTO) {
        final List<WeaknesseDO> weaknesseDOS = pokemonDO.getWeaknesses();
        final List<WeaknessDTO> weaknessDTOS = new ArrayList<>();

        for (WeaknesseDO weaknesseDO : weaknesseDOS) {
            final WeaknessDTO weaknessDTO = new WeaknessDTO();
            weaknessDTO.setMultiple(weaknesseDO.getMultiple());
            weaknessDTO.setTypeName(weaknesseDO.getType().getName());
            weaknessDTOS.add(weaknessDTO);
        }

        pokemonDTO.setWeaknesses(weaknessDTOS);
    }

    List<TypeDO> setListTypes(final List<Integer> typeIds) {
        final List<TypeDO> types = new ArrayList<>();
        for (Integer i : typeIds) {
            final TypeDO typeDO = new TypeDO();
            typeDO.setId(i);
            types.add(typeDO);
        }

        return types;
    }

    List<PokemonDTO> customToDTO(List<CustomPokemon> listCustom) throws IOException {
        final List<PokemonDTO> listDTO = new ArrayList<>();
        for (CustomPokemon customPokemon : listCustom) {
            final PokemonDTO pokemonDTO = new PokemonDTO();

            pokemonDTO.setId(customPokemon.getId());
            pokemonDTO.setName(customPokemon.getName());
            pokemonDTO.setType1(customPokemon.getTypes().get(0).getName());
            if (customPokemon.getTypes().size() == 2) {
                pokemonDTO.setType2(customPokemon.getTypes().get(1).getName());
            }

            setImage(customPokemon.getImage(), pokemonDTO);

            listDTO.add(pokemonDTO);
        }
        return listDTO;
    }
}
