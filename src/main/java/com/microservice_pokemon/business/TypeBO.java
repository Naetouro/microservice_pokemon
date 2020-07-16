package com.microservice_pokemon.business;

import com.microservice_pokemon.data.objects.TypeDO;
import com.microservice_pokemon.data.transfer.object.TypeDTO;
import com.microservice_pokemon.repositories.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeBO {

    @Autowired
    private ITypeRepository repo;

    public List<TypeDTO> findAll(){
        final List<TypeDO> typeDOS = repo.findAll();
        final List<TypeDTO> typeDTOS = new ArrayList<>();

        for (TypeDO typeDO : typeDOS){
            final TypeDTO typeDTO = new TypeDTO(typeDO.getId(), typeDO.getName());
            typeDTOS.add(typeDTO);
        }

        return typeDTOS;
    }


}
