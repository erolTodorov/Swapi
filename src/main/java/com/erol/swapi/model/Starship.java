package com.erol.swapi.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Starship {
     
    @Id
    @GeneratedValue
    @Setter(value = AccessLevel.NONE) // premahva avtomatichno generiran setter
    private Long id;
    private String starshipClass;
    private int MGLT;
    private double hyperdriveRating;

   

     @ManyToMany(mappedBy = "starships")
    private List<People> pilots;

    @ManyToMany(mappedBy = "films")
    private List<Films> films;
    
    @CreationTimestamp
    private LocalDate creationAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    
    
    
}
