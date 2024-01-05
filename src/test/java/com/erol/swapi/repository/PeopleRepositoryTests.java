package com.erol.swapi.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import com.erol.swapi.model.People;

@DataJpaTest
public class PeopleRepositoryTests {

    private static final Long PEOPLE_ID = 15L;


    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @Sql("classpath:db/people15.sql")
    void shouldFetchPeopleIdFromDb(){
        Optional<People> person = peopleRepository.findById(PEOPLE_ID);
        assertTrue(person.isPresent());
    }
    
}
