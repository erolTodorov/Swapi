package com.erol.swapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class vehicles {

@Id
@GeneratedValue
private long id;
private String vehicleClass;
   
    
}
