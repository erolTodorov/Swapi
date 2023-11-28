package com.erol.swapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class vehicles {

@Id
@GeneratedValue
@Setter(value = AccessLevel.NONE)
private long id;
private String vehicleClass;
   
    
}
