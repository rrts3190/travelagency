package edu.wgu.d288_backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@OpenAPIDefinition
public class TravelagencyApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(TravelagencyApplication.class, args);

	}
	//using this link to get all endpoint of api, http://localhost:8080/swagger-ui.html

}
