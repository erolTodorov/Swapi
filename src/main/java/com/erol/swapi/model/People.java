package com.erol.swapi.model;

import java.util.List;

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

@Entity
public class People {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double height;
    private double mass;
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

    
     public List<Starship> getStarships() {
        return starships;
    }
    public void setStarships(List<Starship> starships) {
        this.starships = starships;
    }
    public planets getPlanets() {
        return planets;
    }
    public void setPlanets(planets planets) {
        this.planets = planets;
    }
    public List<Films> getFilms() {
        return films;
    }
    public void setFilms(List<Films> films) {
        this.films = films;
    }
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public String getHair_color() {
        return hair_color;
    }
    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
    public String getSkin_color() {
        return skin_color;
    }
    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }
    public String getEye_color() {
        return eye_color;
    }
    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }
    public String getBirth_year() {
        return birth_year;
    }
    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

}
