package com.erol.swapi.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Starship {
     
    @Id
    @GeneratedValue
    private Long id;
    private String starshipClass;
    private int MGLT;
    private double hyperdriveRating;

   

     @ManyToMany(mappedBy = "starships")
    private List<People> pilots;

    @ManyToMany(mappedBy = "films")
    private List<Films> films;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public int getMGLT() {
        return MGLT;
    }

    public void setMGLT(int mGLT) {
        MGLT = mGLT;
    }

    public double getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(double hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public LocalDate getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(LocalDate creationAt) {
        this.creationAt = creationAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

     public List<People> getPilots() {
        return pilots;
    }

    public void setPilots(List<People> pilots) {
        this.pilots = pilots;
    }


    @CreationTimestamp
    private LocalDate creationAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    
    
    
}
