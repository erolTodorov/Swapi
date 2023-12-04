package com.erol.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erol.swapi.model.Starship;

@Repository
public interface StarshipRepository extends CrudRepository <Starship,Long>{
    
}
