package com.erol.swapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.erol.swapi.model.planets;

@Repository
public interface PlanetPagingRepository   extends  ListPagingAndSortingRepository <planets,Long>{

    List<planets> findAllBy(Pageable pageable);
    
}


