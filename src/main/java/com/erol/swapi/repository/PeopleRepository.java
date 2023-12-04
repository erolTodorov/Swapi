package com.erol.swapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erol.swapi.model.People;

@Repository
public interface PeopleRepository extends CrudRepository <People, Long>{

    

    //  public  List<People> findAllByGenderOrderByFirstNameAsc(Gender gender);

   
    
    // @Query (nativeQuery =  false,value =  "Select p FROM People p")
    // Collection<People> findAllQuery(Sort sorts);
}
