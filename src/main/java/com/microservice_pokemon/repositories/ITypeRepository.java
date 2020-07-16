package com.microservice_pokemon.repositories;

import com.microservice_pokemon.data.objects.TypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<TypeDO, Integer> {

}
