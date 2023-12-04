package com.erol.swapi.web.dto;

import java.util.List;

import com.erol.swapi.constant.Gender;
import com.erol.swapi.model.planets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePeopleRequest {

    private String name;
    private double height;
    private double mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    
    private Gender gender;
    private planets planets;
      
    private List<Long> starshipsIds;
    private List<Long> filmIds;
   
    
}
