package com.erol.swapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "mylogging")
@Profile("dev")
@Data
public class DevInstrumentationSystemProperties {

    private String username;
    private String password;

    
}
