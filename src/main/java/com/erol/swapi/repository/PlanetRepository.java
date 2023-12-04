package com.erol.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erol.swapi.model.planets;

@Repository
public interface PlanetRepository extends CrudRepository <planets,Long>{
    
}
