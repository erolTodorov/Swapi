package com.erol.swapi.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.erol.swapi.constant.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class People {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private long id;
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    
    
     @ManyToOne
    @JoinColumn(name = "planets_id")
    private planets planets;
     
    @ManyToMany(targetEntity = Films.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Films> films;
 
    @ManyToMany
    @JoinTable(
            name = "people_starships",
            joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "starship_id")
    )
    private List<Starship> starships;
    private Gender gender;

    @ManyToMany(targetEntity = vehicles.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<vehicles> vehicles;
    
    @CreationTimestamp
    private LocalDate creationAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    

    
    

}
