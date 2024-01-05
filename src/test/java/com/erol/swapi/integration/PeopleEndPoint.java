package com.erol.swapi.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@Tag("integration-test")
@AutoConfigureMockMvc
public class PeopleEndPoint {
    

    @Autowired
    private MockMvc mock;

    @Test
    @WithMockUser(username = "Roli",roles = {"ADMIN"})

    void addValidPeople() throws Exception{
       mock.perform(post("/people").header(HttpHeaders.CONTENT_TYPE,"application/json").content("""
        {
            "name": "Luck",
            "mass": 111 ,
            "haight": 1.88
        }
               """)).andExpect(status().isCreated())
               .andExpect(jsonPath("$.name").value("Luck"))
               .andExpect(jsonPath("$.id").isNotEmpty());
    }

    void addValidPlanets() throws Exception{
        mock.perform(post("/planets").header(HttpHeaders.CONTENT_TYPE, "application/json").content("""
                 {
            "name": "Planets",
            "climate": "suh" ,
            "diameters": 1.88
        }
                """)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Planets"));
    }
}
