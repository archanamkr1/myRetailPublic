package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringRestprojectApplication {
    @Bean
    public RestTemplate getrestTemplate(){
    	RestTemplate restTemplate=new RestTemplate();
    	return restTemplate;
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringRestprojectApplication.class, args);
	}

}
