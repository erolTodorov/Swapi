package com.erol.swapi.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.erol.swapi.model.People;

public interface PeoplePagingRepository extends ListPagingAndSortingRepository<People,Long> {
    
}
