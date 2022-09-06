package com.example.Cropservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Crops",version = "2.0",description = "Microservice 1"))

public class CropServiceApplication {


	


	public static void main(String[] args) {
		SpringApplication.run(CropServiceApplication.class, args);
	}

}
