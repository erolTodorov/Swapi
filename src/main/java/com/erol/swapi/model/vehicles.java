package com.erol.swapi.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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


@ManyToMany
    @JoinTable(name = "people_vehicles", joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicles_id"))
    private List<People> people;

@CreationTimestamp
private LocalDate createdAt;

@UpdateTimestamp
private LocalDate updatedAt;

   
    
}
