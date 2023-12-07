package com.erol.swapi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
public class planets {

    
    @Id
    @GeneratedValue
    @Setter(value = AccessLevel.NONE)
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

    

     @OneToMany(mappedBy = "planets")
    private Set<People> peoples;
     
     @ManyToMany(targetEntity = Films.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Films> films;
 
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updetedAt;


   
   
    





    
}

