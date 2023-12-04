package com.erol.swapi.web.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdatePeopleVehicleRequest {
    
    private Set<Long> vehiclesIds;
}
