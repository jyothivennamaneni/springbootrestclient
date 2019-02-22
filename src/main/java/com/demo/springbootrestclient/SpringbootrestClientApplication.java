package com.demo.springbootrestclient;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@PropertySource("endpoints.properties")
public class SpringbootrestClientApplication{
	
    private static final Logger LOGGER = Logger.getLogger(SpringbootrestClientApplication.class.getName());

    @Value("${public-api.url}")
    private String publicApiUrl;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
        return args -> {

        	LOGGER.info(restTemplate.getForObject(publicApiUrl, String.class));
        };
    }

}