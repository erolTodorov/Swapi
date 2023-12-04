package com.erol.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erol.swapi.model.vehicles;

@Repository
public interface VehiclesRepository extends CrudRepository<vehicles,Long>{
    
}
