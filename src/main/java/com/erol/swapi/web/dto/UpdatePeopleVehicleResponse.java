package com.erol.swapi.web.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UpdatePeopleVehicleResponse {
  

    private Set<Long> vehiclesIds;
}
