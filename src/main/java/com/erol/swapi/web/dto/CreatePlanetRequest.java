package com.erol.swapi.web.dto;

import java.util.List;
import java.util.Set;

import com.erol.swapi.model.People;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlanetRequest {
    
    @NotBlank
    private long id;
    private String name;
    private String climate;
    private int surface_water;
    private int diameter;
    private int rotation_period;
    private String terrain;
    private String gravity;
    private int orbital_period;
    private long population;

    
    
    private Set<People> peoples;
    private List<Long> filmIds;
}
