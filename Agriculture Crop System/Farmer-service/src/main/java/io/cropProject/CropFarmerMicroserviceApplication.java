package io.cropProject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Farmer",version = "2.0",description = "Microservice2"))
public class CropFarmerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CropFarmerMicroserviceApplication.class, args);
	}

}
