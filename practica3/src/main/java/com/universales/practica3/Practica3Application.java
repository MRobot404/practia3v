package com.universales.practica3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.universales.libreria")
public class Practica3Application {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(Practica3Application.class, args);
	}
	
	

}
