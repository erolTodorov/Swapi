package com.erol.swapi.json;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import com.erol.swapi.web.dto.CreatePeopleRequest;


@JsonTest
public class PeopleSerializationTest {

    @Autowired
    private JacksonTester<CreatePeopleRequest> cpReqTester;

    @Test
    void serializePeoplerequest() throws IOException{
        CreatePeopleRequest req = CreatePeopleRequest.builder().name("Pesho").build();

        JsonContent<CreatePeopleRequest> json = cpReqTester.write(req);
        assertThat(json).extractingJsonPathStringValue("$.name").isEqualTo("Pesho");
        
    }
    
}
