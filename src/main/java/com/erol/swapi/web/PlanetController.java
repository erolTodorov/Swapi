package com.erol.swapi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erol.swapi.error.NotFoundObjectException;
import com.erol.swapi.model.Films;
import com.erol.swapi.model.planets;
import com.erol.swapi.repository.FilmRepository;
import com.erol.swapi.repository.PeopleRepository;
import com.erol.swapi.repository.PlanetRepository;
import com.erol.swapi.service.ObjectValidator;
import com.erol.swapi.web.dto.CreatePlanetRequest;

@RestController
public class PlanetController {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ObjectValidator validator;
    


    @GetMapping(value =  "/planets")
    private List<planets> getAllPlanets(){
           return (List<planets>) planetRepository.findAll();
           
    }

    @GetMapping(value =  "planets/{id}")
     private planets getPlanetsByID(@PathVariable Long id){
       return planetRepository.findById(id).orElseThrow(() -> {
         throw new NotFoundObjectException(planets.class.getName(), String.valueOf(id));

       });
    }
   
    @PostMapping (value =  "/planets")
    private planets createPlanets(@RequestBody CreatePlanetRequest planetRequest){
        validator.validate(planetRequest);

        List<Films> films = new ArrayList<>();

        if(planetRequest.getFilmIds() != null){
            films = (List<Films>) filmRepository.findAllById(planetRequest.getFilmIds());

        }
        planets Planets = planets.builder().name(planetRequest.getName())
        .films(films).build();

        return planetRepository.save(Planets);
    }
    


    @DeleteMapping("planets/{id}")
       private void deletePlanet(@PathVariable Long id ){
       planetRepository.deleteById(id);
   }

 }


    

