package com.erol.swapi.web.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePeopleStarshipsResponse {
    
    private Set<Long> starshipsIds;
}
