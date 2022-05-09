package com.onrcnk.citysports;

import com.onrcnk.citysports.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CitySportsApplication {


	public static void main(String[] args){
		SpringApplication.run(CitySportsApplication.class, args);

	}



}