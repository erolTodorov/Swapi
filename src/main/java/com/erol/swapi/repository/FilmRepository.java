package com.erol.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erol.swapi.model.Films;

@Repository
public interface FilmRepository extends CrudRepository <Films , Long> {


    
}
