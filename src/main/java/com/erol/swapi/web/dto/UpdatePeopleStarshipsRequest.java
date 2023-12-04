package com.erol.swapi.web.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UpdatePeopleStarshipsRequest {

    private Set<Long> starshipsIds;
    
}
