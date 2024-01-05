package com.erol.swapi.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erol.swapi.error.NotFoundObjectException;
import com.erol.swapi.model.Films;
import com.erol.swapi.model.People;
import com.erol.swapi.model.Starship;
import com.erol.swapi.model.vehicles;
import com.erol.swapi.repository.FilmRepository;
import com.erol.swapi.repository.PeoplePagingRepository;
import com.erol.swapi.repository.PeopleRepository;
import com.erol.swapi.repository.StarshipRepository;
import com.erol.swapi.repository.VehiclesRepository;
import com.erol.swapi.service.ObjectValidator;
import com.erol.swapi.web.dto.CreatePeopleRequest;
import com.erol.swapi.web.dto.UpdatePeopleRequest;
import com.erol.swapi.web.dto.UpdatePeopleStarshipsRequest;
import com.erol.swapi.web.dto.UpdatePeopleStarshipsResponse;
import com.erol.swapi.web.dto.UpdatePeopleVehicleRequest;
import com.erol.swapi.web.dto.UpdatePeopleVehicleResponse;

import jakarta.validation.Valid;



@RestController
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private StarshipRepository starshipRepository;

    @Autowired
    private VehiclesRepository vehiclesRepository;

     @Autowired
    private ObjectValidator validator;

    // @Autowired
    // public PeopleMapper peopleMapper;

    @Autowired
    private PeoplePagingRepository peoplePagingRepository;


     @GetMapping(value="/people")
    private List<People> getAllPeoples(){
        return (List<People>) peopleRepository.findAll(); 
    }
    
      @GetMapping(value = "/people/{id}")
      private People getPeopleId(@PathVariable Long id){
       return peopleRepository.findById(id).orElseThrow(() -> {
             throw new NotFoundObjectException(People.class.getName(), String.valueOf(id));
         });
    }

     @PostMapping(value="/people")
    private People createPeople(@RequestBody  @Valid CreatePeopleRequest peopleRequest){
        
        
         List<Films> films = new ArrayList<>();
        if (peopleRequest.getFilmIds() != null) {
            films = (List<Films>) filmRepository.findAllById(peopleRequest.getFilmIds());
        }

        People people = People.builder().name(peopleRequest.getName())
               .films(films).build();
               

        return peopleRepository.save(people);
    }
    
    @PatchMapping(value = "/people/{id}")
    private People updatPeople(@PathVariable Long id,
    @RequestBody  UpdatePeopleRequest peopleRequest){

        People people = peopleRepository.findById(id).get();

        if(peopleRequest.getName() != null){
            people.setName(peopleRequest.getName());
        }
        if(peopleRequest.getBirth_year() !=null){
            people.setBirth_year(peopleRequest.getBirth_year());
        }
        if(peopleRequest.getGender() != null){
            people.setGender(peopleRequest.getGender());
        }
        if (peopleRequest.getEye_color() != null){
            people.setEye_color(peopleRequest.getEye_color());
        }
        if (peopleRequest.getHair_color() != null){
            people.setHair_color(peopleRequest.getHair_color());
        }
        if(peopleRequest.getPlanets() != null){
            people.setPlanets(peopleRequest.getPlanets());

        }
        // if(peopleRequest.getStarshipsIds() != null){
        //     List<Starship> starships = (List<Starship>) starshipRepository.findAllById(people.getStarshipsIds());
        //      people.setStarships(starships);
        // }

        if (peopleRequest.getFilmIds() != null) {
            List<Films> films = (List<Films>) filmRepository.findAllById(peopleRequest.getFilmIds());

            people.setFilms(films);
        }

        return peopleRepository.save(people);
    }

    @PutMapping(value = "/people/{id}/starships")
    private UpdatePeopleStarshipsResponse updateStarships(@PathVariable Long id,
    @RequestBody UpdatePeopleStarshipsRequest peopleStarships){
        People people = peopleRepository.findById(id).get();

        List<Starship> starshipsInDB = 
              (List<Starship>) starshipRepository.findAllById(peopleStarships.getStarshipsIds());

        people.setStarships((List<Starship>) (starshipsInDB.stream().collect(Collectors.toSet())));


        Set<Long> starshipsIds = peopleRepository.save(people).getStarships().stream().map(p -> p.getId())
        .collect(Collectors.toSet());

        return UpdatePeopleStarshipsResponse.builder().starshipsIds(starshipsIds).build();
    }

  

    @GetMapping ("/people/{id}/starships")
    private UpdatePeopleStarshipsResponse updateStarships(@PathVariable Long id){
        People people = peopleRepository.findById(id).get();

        Set<Long> starshipsIds = 
                people.getStarships().stream().map(p -> p.getId()).collect(Collectors.toSet());

        return UpdatePeopleStarshipsResponse.builder().starshipsIds(starshipsIds).build();
    }

    
    @PutMapping("/people/{id}/vehicles")
    private UpdatePeopleVehicleResponse updateVehicle(@PathVariable Long id,
    @RequestBody UpdatePeopleVehicleRequest peopleVehicles){
        People people = peopleRepository.findById(id).get();

        List<vehicles> vehiclesInDB = (List<vehicles>) vehiclesRepository.findAllById(peopleVehicles.getVehiclesIds());
        people.setVehicles((List<vehicles>) (vehiclesInDB.stream().collect(Collectors.toSet())));

        Set<Long> vehicleIds = peopleRepository.save(people).getVehicles().stream().map(p -> p.getId())
        .collect(Collectors.toSet());

        return UpdatePeopleVehicleResponse.builder().vehiclesIds(vehicleIds).build();
    }
    

    @GetMapping("/people/{id}/vehicles")
    private UpdatePeopleVehicleResponse updateVehicles(@PathVariable Long id){
        People people = peopleRepository.findById(id).get();

        Set<Long> vehiclesIds = 
                  people.getVehicles().stream().map(p -> p.getId()).collect(Collectors.toSet());

        
        return UpdatePeopleVehicleResponse.builder().vehiclesIds(vehiclesIds).build();

    }



    
    @DeleteMapping("/people/{id}")
    private void deletePeople(@PathVariable Long id){
        peopleRepository.deleteById(id);
    }
}
