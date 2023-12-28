package com.erol.swapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.erol.swapi.model.People;

public interface PeoplePagingRepository extends ListPagingAndSortingRepository<People,Long> {

    List<People> findAllBy(Pageable pageable);
    
}
